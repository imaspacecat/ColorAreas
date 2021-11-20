import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\yotam\\Desktop\\tinyLines.png"));

            Random rand = new Random();
            int randX = rand.nextInt(image.getWidth());
            int randY = rand.nextInt(image.getHeight());

            System.out.println(image.getRGB(randX, randY));

            Color randColor = new Color(rand.nextInt(256) - 1, rand.nextInt(256) - 1, rand.nextInt(256) - 1);

            randColor = Color.BLUE;
            //black = -16777216, white = -1


                Recursion(image, 0, 0, randColor);
//            image.setRGB(randX, randY, randColor.getRGB());


            ImageIO.write(image, "png", new File("C:\\Users\\yotam\\Desktop\\customImage.png"));
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    private static void Recursion(BufferedImage image, int initX, int initY, Color color) {
        for(int x = initX-1; x <= initX+1; x++){
            if(x < 0 || x >= image.getWidth()){
                continue;
            }
            for(int y = initY-1; y <= initY+1; y++){
                if(y < 0 || y >= image.getHeight()){
                    continue;
                }
                boolean painted = paintPixel(image, x, y, color);
                if(painted){
                    Recursion(image, x, y, color);
                }
            }
        }

    }

    private static boolean paintPixel(BufferedImage image, int initX, int initY, Color color) {
        boolean hasColor = false;
        if(image.getRGB(initX, initY) == Color.WHITE.getRGB()){
            System.out.println("x: " + initX + " y: " + initY + " color: " + image.getRGB(initX, initY));
            image.setRGB(initX, initY, color.getRGB());
            hasColor = true;
        }

        return hasColor;
    }

}
