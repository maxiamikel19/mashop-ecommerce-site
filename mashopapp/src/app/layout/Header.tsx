import { ShoppingCart } from "@mui/icons-material";
import { AppBar, Badge, Box, IconButton, List, ListItem, Switch, Toolbar, Typography } from "@mui/material";
import { NavLink } from "react-router-dom";

const listNavegation = [
    {title: 'Home', path:'/'},
    {title: 'Store', path:'/store'},
    {title: 'Contact', path:'/contact'}
]

const listCredentials = [
    {title: 'Login', path:'/login'},
    {title: 'Register', path:'/register'}
]

const styleNavegation = {
    color: "inherit",
    typography: "h6",
    tedtDecoration: "none",
    "&:hover":{
        color: "secondary.main",
    },
    "&:active":{
        color: "tect.secondary"
    }
}

interface Props{
    blackBackground: boolean;
    handleThemeChange: () => void;
}

export default function Header({blackBackground, handleThemeChange}: Props){
    return (
        <AppBar position="static" sx={{mb:4}}>
            <Toolbar sx={{
                display: "flex",
                justifyContent: "space-between",
                alignItems: "center"
            }}>
                <Box display='flex' alignItems='center'>
                <Typography variant="h6">
                    MaShop, your choice
                </Typography>
            <Switch checked={blackBackground} onChange={handleThemeChange}></Switch>
            </Box>
            <List sx={{display:'flex'}}>
                {listNavegation.map(({title, path}) => (
                    <ListItem component={NavLink} to={path} key={path} sx={styleNavegation} >
                        {title}
                    </ListItem>
                )
                )}
            </List>
            <Box display='flex' alignItems='center'>
                <IconButton size='large' edge='start' color='inherit' sx={{mr:2}}>
                    <Badge badgeContent='0' color='secondary'>
                        <ShoppingCart />
                    </Badge>
                </IconButton>
                <List sx={{display:'flex'}}>
                    {listCredentials.map(({title, path}) => (
                        <ListItem component={NavLink} to={path} key={path} sx={styleNavegation}>
                            {title}
                        </ListItem>
                    )
                    )}
                </List>
            </Box>
            </Toolbar>
        </AppBar>
    );
}