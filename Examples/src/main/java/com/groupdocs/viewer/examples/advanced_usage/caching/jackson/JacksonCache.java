package com.groupdocs.viewer.examples.advanced_usage.caching.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.groupdocs.viewer.caching.Cache;
import com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model.*;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.results.*;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonCache implements Cache {
    private final ObjectMapper mObjectMapper;
    private final Map<String, byte[]> mData = new HashMap<>();
    private static final Class<?>[] SERIALIZATION_MODELS = new Class[]{
            ArchiveViewInfoModel.class,
            AttachmentModel.class,
            CadViewInfoModel.class,
            CharacterModel.class,
            FileInfoModel.class,
            LayerModel.class,
            LayoutModel.class,
            LineModel.class,
            LotusNotesViewInfoModel.class,
            OutlookViewInfoModel.class,
            PageModel.class,
            PdfViewInfoModel.class,
            ProjectManagementViewInfoModel.class,
            ViewInfoModel.class,
            WordModel.class
    };

    public JacksonCache() {
        mObjectMapper = new ObjectMapper();
        mObjectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mObjectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        SimpleModule module = new SimpleModule(Version.unknownVersion());

        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
        resolver.addMapping(ArchiveViewInfo.class, ArchiveViewInfoModel.class);
        resolver.addMapping(Attachment.class, AttachmentModel.class);
        resolver.addMapping(CadViewInfo.class, CadViewInfoModel.class);
        resolver.addMapping(Character.class, CharacterModel.class);
        resolver.addMapping(FileInfo.class, FileInfoModel.class);
        resolver.addMapping(Layer.class, LayerModel.class);
        resolver.addMapping(Layout.class, LayoutModel.class);
        resolver.addMapping(Line.class, LineModel.class);
        resolver.addMapping(LotusNotesViewInfo.class, LotusNotesViewInfoModel.class);
        resolver.addMapping(OutlookViewInfo.class, OutlookViewInfoModel.class);
        resolver.addMapping(Page.class, PageModel.class);
        resolver.addMapping(PdfViewInfo.class, PdfViewInfoModel.class);
        resolver.addMapping(ProjectManagementViewInfo.class, ProjectManagementViewInfoModel.class);
        resolver.addMapping(ViewInfo.class, ViewInfoModel.class);
        resolver.addMapping(Word.class, WordModel.class);

        module.setAbstractTypes(resolver);

        mObjectMapper.registerModule(module);
    }

    @Override
    public void set(String key, Object value) {
        final byte[] bytes;
        try {
            if (value instanceof InputStream) {
                bytes = IOUtils.toByteArray((InputStream) value);
            } else {
                bytes = mObjectMapper.writeValueAsBytes(value);
            }
            // Here bytes could be written to file or sent somewhere
            mData.put(key, bytes);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        final byte[] bytes = mData.get(key);
        if (bytes == null) {
            return null;
        }

        try {
            for (Class<?> clazz : SERIALIZATION_MODELS) {
                try {
                    return (T) mObjectMapper.readValue(bytes, clazz);
                } catch (JsonParseException | JsonMappingException e) {
                    // continue, is not this type or is stream
                }
            }
            return (T) new ByteArrayInputStream(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getKeys(String filter) {
        List<String> filtered = new ArrayList<>();
        for (String key : mData.keySet()) {
            // Do your filtering
            if (key.startsWith(filter)) {
                filtered.add(key);
            }
        }
        return filtered;
    }
}
