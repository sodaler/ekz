import React from "react"
import Header from "./Header";

interface LayoutProps {
    children: any;
}

const Layout: React.FC<LayoutProps> = ({ children }) => {
    return (
        <div>
            <Header></Header>
            {children}
        </div>
    )

}

export default Layout