package com.groupdocs.ui.viewer.cache;

import com.groupdocs.ui.viewer.cache.model.*;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.caching.extra.CacheableFactory;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.results.*;

import java.util.Date;
import java.util.List;

public class FileViewerCacheableFactory extends CacheableFactory {
    @Override
    public ViewInfo newViewInfo(FileType fileType, List<Page> pages) {
        return new ViewInfoModel(fileType.name(), pages);
    }

    @Override
    public LotusNotesViewInfo newLotusNotesViewInfo(FileType fileType, List<Page> pages, int notesCount) {
        return new LotusNotesViewInfoModel(fileType.name(), pages, notesCount);
    }

    @Override
    public ArchiveViewInfo newArchiveViewInfo(FileType fileType, List<Page> pages, List<String> folders) {
        return new ArchiveViewInfoModel(fileType.name(), pages, folders);
    }

    @Override
    public Character newCharacter(char character, double x, double y, double width, double height) {
        return new CharacterModel(character, x, y, width, height);
    }

    @Override
    public FileInfo newFileInfo(FileType fileType) {
        return new FileInfoModel(fileType.name());
    }

    @Override
    public Layer newLayer(String name, boolean visible) {
        return new LayerModel(name, visible);
    }

    @Override
    public Layer newLayer(String name) {
        return new LayerModel(name);
    }

    @Override
    public Layout newLayout(String name, double width, double height) {
        return new LayoutModel(name, width, height);
    }

    @Override
    public Line newLine(String line, double x, double y, double width, double height, List<Word> words) {
        return new LineModel(line, x, y, width, height, words);
    }

    @Override
    public Attachment newAttachment(String id, String fileName, String filePath, long size) {
        return new AttachmentModel(id, fileName, filePath, size);
    }

    @Override
    public Attachment newAttachment(String id, String fileName, String filePath, FileType fileType, long size) {
        return new AttachmentModel(id, fileName, filePath, fileType, size);
    }

    @Override
    public OutlookViewInfo newOutlookViewInfo(FileType fileType, List<Page> pages, List<String> folders) {
        return new OutlookViewInfoModel(fileType.name(), pages, folders);
    }

    @Override
    public Page newPage(int number, String name, boolean visible) {
        return new PageModel(number, name, visible);
    }

    @Override
    public Page newPage(int number, String name, boolean visible, int width, int height) {
        return new PageModel(number, name, visible, width, height);
    }

    @Override
    public Page newPage(int number, boolean visible, int width, int height) {
        return new PageModel(number, visible, width, height);
    }

    @Override
    public Page newPage(int number, String name, boolean visible, int width, int height, List<Line> lines) {
        return new PageModel(number, name, visible, width, height, lines);
    }

    @Override
    public Page newPage(int number, boolean visible, int width, int height, List<Line> lines) {
        return new PageModel(number, visible, width, height, lines);
    }

    @Override
    public PdfViewInfo newPdfViewInfo(FileType fileType, List<Page> pages, boolean printingAllowed) {
        return new PdfViewInfoModel(fileType.name(), pages, printingAllowed);
    }

    @Override
    public CadViewInfo newCadViewInfo(FileType fileType, List<Page> pages, List<Layer> layers, List<Layout> layouts) {
        return new CadViewInfoModel(fileType.name(), pages, layers, layouts);
    }

    @Override
    public ProjectManagementViewInfo newProjectManagementViewInfo(FileType fileType, List<Page> pages, Date startDate, Date endDate) {
        return new ProjectManagementViewInfoModel(fileType.name(), pages, startDate, endDate);
    }

    @Override
    public Word newWord(String word, double x, double y, double width, double height, List<Character> characters) {
        return new WordModel(word, x, y, width, height, characters);
    }
}
