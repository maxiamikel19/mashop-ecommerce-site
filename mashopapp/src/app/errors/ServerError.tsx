import { Container, Paper, Typography, Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

export default function ServerError(){
    
    const navigate = useNavigate();
        const handleHome = () => {
            navigate("/");
        }

        return (
            <Container component={Paper} sx={{p: 4, display:'flex', flexDirection:'column', alignItems:'center', justifyContent:'center'}}>
                 <Typography variant="h6" component="h4" gutterBottom>
              <h1>404</h1>
             </Typography>
             <Typography variant="h3" component="h4" gutterBottom>
                <h3>Internal server error</h3>
             </Typography>  
                 <Button variant="contained" color="primary" onClick={handleHome}>
                    Back to home
                 </Button>
            </Container>
           
        )
}