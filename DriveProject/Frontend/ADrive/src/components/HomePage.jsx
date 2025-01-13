import VerticalMenu from "./VerticalMenu";
import React, { useRef } from "react";

const HomePage = () => {

    const fileInputRef = useRef(null);
    const folderInputRef = useRef(null);

    const handleButtonClickForFile = () => {
        console.log("File Button Clicked....")
        fileInputRef.current.click(); // Programmatically open the file dialog
    };


    const handleButtonClickForFolder = () => {
        folderInputRef.current.click(); // Programmatically open the file dialog
    };

    const handleFileChangeFile = (event) => {
        console.log("Clicked .....")
        const selectedFiles = event.target.files;

        
        console.log("Selected files:", selectedFiles);
    };

    const handleFileChangeFolder = (event) => {
        const selectedFolder = event.target.files;
        console.log("Selected files:", selectedFolder);
    };

    return (
        <div>
            <VerticalMenu />
            <div className="home-page">
                <p className="title-text">Welcome To ADrive</p>
                <div className="button-container">
                    <button className='btn mt-3 extra-width btn-text' onClick={handleButtonClickForFile}>
                        Upload Files
                    </button>
                    <input
                        type="file"
                        id="file_upload"
                        ref={fileInputRef}
                        style={{ display: "none" }} // Hides the input
                        onChange={handleFileChangeFile}
                        // webkitdirectory="true" // For folder selection
                        // mozdirectory="true" // Firefox-specific
                    />
                    <button className='btn mt-3 extra-width btn-text' onClick={handleButtonClickForFolder}>
                        Upload Folders
                    </button>
                    <input
                        type="file"
                        id="folder_uplad"
                        ref={folderInputRef}
                        style={{ display: "none" }} // Hides the input
                        onChange={handleFileChangeFolder}
                        webkitdirectory="true" // For folder selection
                        mozdirectory="true" // Firefox-specific
                    />
                </div>
            </div>
        </div>
    );
};

export default HomePage;