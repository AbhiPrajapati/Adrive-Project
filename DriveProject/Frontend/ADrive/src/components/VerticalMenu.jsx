import React from 'react';
import { NavLink } from 'react-router-dom'; // Import NavLink for navigation
import { FaHome, FaUser , FaImage, FaVideo, FaComments, FaFileAlt, FaCog } from 'react-icons/fa'; // Import icons from react-icons
import '../index.css'; // Import your CSS file

const VerticalMenu = () => {
    return (
        <div className="vertical-menu">
             <NavLink to="/home" className="menu-item" activeClassName="active">
                <FaHome  className="icon" />
                <span className="menu-text">Home</span>
            </NavLink>
            <NavLink to="/profile" className="menu-item" activeClassName="active">
                <FaUser  className="icon" />
                <span className="menu-text">Profile</span>
            </NavLink>
            <NavLink to="/photos" className="menu-item" activeClassName="active">
                <FaImage className="icon" />
                <span className="menu-text">Photos</span>
            </NavLink>
            <NavLink to="/videos" className="menu-item" activeClassName="active">
                <FaVideo className="icon" />
                <span className="menu-text">Videos</span>
            </NavLink>
            <NavLink to="/chats" className="menu-item" activeClassName="active">
                <FaComments className="icon" />
                <span className="menu-text">Chats</span>
            </NavLink>
            <NavLink to="/documents" className="menu-item" activeClassName="active">
                <FaFileAlt className="icon" />
                <span className="menu-text">Documents</span>
            </NavLink>
            <NavLink to="/settings" className="menu-item" activeClassName="active">
                <FaCog className="icon" />
                <span className="menu-text">Settings</span>
            </NavLink>
        </div>
    );
};

export default VerticalMenu;