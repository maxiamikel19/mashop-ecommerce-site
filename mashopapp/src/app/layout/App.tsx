import { Container, CssBaseline, ThemeProvider, createTheme, darkScrollbar } from "@mui/material"
import Catalogo from "../features/catalogo/Catalogo"
import Header from "./Header"
import { useState } from "react"

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
        <Catalogo />
      </Container>
    </ThemeProvider>
  )
}

export default App
