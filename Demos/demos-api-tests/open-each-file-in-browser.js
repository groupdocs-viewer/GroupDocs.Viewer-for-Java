// Navigate to the URL
const url = "http://localhost:8080/viewer";
// window.location.href = url;

// Perform the actions for each file
const fileNames = [
    "GroupDocs_Demo.bmp",
    "GroupDocs_Demo.csv",
    "GroupDocs_Demo.doc",
    "GroupDocs_Demo.docm",
    "GroupDocs_Demo.docx",
    "GroupDocs_Demo.dot",
    "GroupDocs_Demo.dotm",
    "GroupDocs_Demo.dotx",
    "GroupDocs_Demo.dwg",
    "GroupDocs_Demo.dxf",
    "GroupDocs_Demo.eml",
    "GroupDocs_Demo.gif",
    "GroupDocs_Demo.html",
    "GroupDocs_Demo.ifc",
    "GroupDocs_Demo.igs",
    "GroupDocs_Demo.jpeg",
    "GroupDocs_Demo.mht",
    "GroupDocs_Demo.mhtml",
    "GroupDocs_Demo.mpp",
    "GroupDocs_Demo.mpt",
    "GroupDocs_Demo.msg",
    "GroupDocs_Demo.ods",
    "GroupDocs_Demo.odt",
    "GroupDocs_Demo.one",
    "GroupDocs_Demo.ost",
    "GroupDocs_Demo.ott",
    "GroupDocs_Demo.pdf",
    "GroupDocs_Demo.png",
    "GroupDocs_Demo.pps",
    "GroupDocs_Demo.ppt",
    "GroupDocs_Demo.pptx",
    "GroupDocs_Demo.psd",
    "GroupDocs_Demo.rtf",
    "GroupDocs_Demo.stl",
    "GroupDocs_Demo.svg",
    "GroupDocs_Demo.tiff",
    "GroupDocs_Demo.txt",
    "GroupDocs_Demo.vdw",
    "GroupDocs_Demo.vdx",
    "GroupDocs_Demo.vsd",
    "GroupDocs_Demo.vsdm",
    "GroupDocs_Demo.vsdx",
    "GroupDocs_Demo.vss",
    "GroupDocs_Demo.vst",
    "GroupDocs_Demo.vsx",
    "GroupDocs_Demo.vtx",
    "GroupDocs_Demo.xls",
    "GroupDocs_Demo.xlsb",
    "GroupDocs_Demo.xlsm",
    "GroupDocs_Demo.xlsx",
    "GroupDocs_Demo.xltm",
    "GroupDocs_Demo.xltx",
    "GroupDocs_Demo.xml",
    "GroupDocs_Demo.xps",
    "T-Flange.igs",
];

function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function delayWhileLoading() {
    return new Promise((resolve) => {
        const checkExistence = () => {
            const loadingDiv = document.querySelector('div.loading-message');
            if (loadingDiv) {
                setTimeout(checkExistence, 100); // Check again after 100 milliseconds
            } else {
                resolve(); // Element no longer exists, resolve the promise
            }
        };
        checkExistence(); // Start checking for the element's existence
    });
}

function closeErrorDialog() {
    const errorDiv = document.querySelector('div.gd-modal-error-title');
    if (errorDiv) {
        document.querySelector('div.gd-modal-close').click();
    }
    return errorDiv
}

async function runScript() {
    alert("Do not forget to delete 'cache' directory!")

    await delay(2000); // Wait for page load (adjust delay time as needed)

    for (let i = 0; i < fileNames.length; i++) {
        const fileName = fileNames[i];

        // Click on the Browse files button
        const browseButton = document.querySelector("gd-button[title='Browse files']");
        browseButton.click();

        await delay(1000); // Wait for the browse files action to complete (adjust delay time as needed)

        // Click on the file with the given name
        const divElements = document.querySelectorAll("div.file-name");
        let fileElement = null;

        divElements.forEach((element) => {
            if (element.textContent === fileName) {
                fileElement = element;
            }
        });
        fileElement.click();

        await delay(500);
        console.log("Loading: '" + fileName + "' ...")
        // alert("Press 'Enter' to continue...")

        await delay(1000);
        await delayWhileLoading();
        if (closeErrorDialog()) {
            console.log("Loading: '" + fileName + "' was FAILED!");
        } else {
            console.log("Loading: '" + fileName + "' finished!");
        }
        await delay(2000);
    }
    alert("All files are iterated!")
}

runScript();
