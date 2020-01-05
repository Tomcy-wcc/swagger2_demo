package com.ys.swagger_demo;

import com.itextpdf.text.PageSize;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description
 * @auther wcc
 * @create 2020-01-02 21:19
 */
public class ImageUtil {

    public static void main(String[] args) throws IOException {
        splitImage();
    }

    private static void splitImage() throws IOException, IOException {

        String originalImg = "C:\\Users\\wcc\\Desktop\\123.png";
        // 读入大图
        File file = new File(originalImg);
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis);

        int width = image.getWidth();
        int height = image.getHeight();

        float bl = width / PageSize.A4.getWidth();

        int h = (int) (PageSize.A4.getHeight() * bl);
        // 要截成几张图
        int rows = height % h == 0 ? height / h : height / h + 1;

        // 计算每个小图的宽度和高度
        int chunkWidth = width;
        int chunkHeight = h;

        BufferedImage imgs[] = new BufferedImage[rows];
        for (int x = 0; x < rows; x++) {
            //设置小图的大小和类型
            imgs[x] = new BufferedImage(chunkWidth, chunkHeight, image.getType());
            //写入图像内容
            Graphics2D gr = imgs[x].createGraphics();
            //图片的大小dx1 dy1 chunkWidth imageHeight
            //把图片image区域sx1, sy1 sx2 sy2画到imgs[count++]的dx1 dy1 chunkWidth imageHeight区域
            int sy2 = chunkHeight * x + chunkHeight;
            int dy2 = chunkHeight;
            if (chunkHeight * x + chunkHeight > height) { // 最后一张图片
                sy2 = height;
                dy2 = height - chunkHeight * x;
            }
            gr.drawImage(image, 0, 0,
                    chunkWidth, dy2,
                    0, chunkHeight * x,
                    chunkWidth,
                    sy2, null);
            gr.dispose();
        }

        // 输出小图
        for (int i = 0; i < imgs.length; i++) {
            ImageIO.write(imgs[i], "png", new File("C:\\Users\\wcc\\Desktop\\img" + i + ".jpg"));
        }

        System.out.println("完成分割！");
    }

}
