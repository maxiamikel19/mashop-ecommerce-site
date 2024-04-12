import { AppBar, Switch, Toolbar, Typography } from "@mui/material";
interface Props{
    blackBackground: boolean;
    handleThemeChange: () => void;
}

export default function Header({blackBackground, handleThemeChange}: Props){
    return (
        <AppBar position="static" sx={{mb:4}}>
            <Toolbar>
                <Typography variant="h6">
                    MaShop, your choice
                </Typography>
            <Switch checked={blackBackground} onChange={handleThemeChange}></Switch>
            </Toolbar>
        </AppBar>
    );
}