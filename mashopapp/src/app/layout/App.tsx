import { Container, CssBaseline, ThemeProvider, createTheme } from "@mui/material";
import { useState } from "react";
import { Outlet } from "react-router-dom";
import Header from "./Header";

function App() { 

  const [blackBackground, setBlackBackground] = useState(false);
  const paleteColor = blackBackground ? 'dark' : 'light';
  const theme = createTheme({
    palette:{
      mode: paleteColor, 
    }
  })

  function handleThemeChange(){
    setBlackBackground(!blackBackground);
  }
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Header blackBackground={blackBackground} handleThemeChange={handleThemeChange}/>
      <Container>
        {/* <Catalogo /> */}
        <Outlet />
      </Container>
    </ThemeProvider>
  )
}

export default App
