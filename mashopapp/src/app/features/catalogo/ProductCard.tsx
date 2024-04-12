import { Avatar, Button, Card, CardActions, CardContent, CardHeader, CardMedia, Typography } from "@mui/material";
import { Product } from "../../models/product";

interface Props{
    product: Product;
}
export default function ProductCard({product}: Props){

    const extractImageName = (item: Product): string  | null => {
        if(item && item.pictureUrl){
            const partUrl = item.pictureUrl.split('/');
            if(partUrl.length > 0){
                return partUrl[partUrl.length-1];
            }
        }
        return null;
    }

    
    const formatarPrice = (price: number): string =>{
        return new Intl.NumberFormat('pt-Br',{
            style:'currency',
            currency:'INR',
            minimumFractionDigits:2
        }).format(price)
    }

    return(
        <Card >
            <CardHeader avatar={
                <Avatar sx={{bgcolor: 'secondary.main'}}>
                    {product.name.charAt(0).toUpperCase()}
                </Avatar>
            }
            title={product.name}
            titleTypographyProps={{sx:{fontWeight: 'bold', color:'primary.main'}}}
            />
            <CardMedia 
                sx={{height: 140, backgroundSize:'contain'}}
                image={"/images/product/"+extractImageName(product)}
                title={product.name}
            />
            <CardContent>
                <Typography gutterBottom color='secondary' variant="h5">
                    {formatarPrice(product.price)}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    {product.brand} / {product.type}
                </Typography>
            </CardContent>
            <CardActions>
                <Button size="small">Add to Card</Button>
                <Button size="small">View details</Button>
            </CardActions>
        </Card>
    );
}