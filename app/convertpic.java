import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


public class convertpic {
	public static void convertteacher(){
    	String srcImageFile = "/home/ubuntu/learnmore/public/images/teacher/";
    	String result = "/home/ubuntu/lmmobilesite/public/images/teacher/100x100/";
    	File dir = new File(srcImageFile);
    	File file[] = dir.listFiles();
    	List<File> flist = new ArrayList<File>(); 
    	for (int i = 0; i < file.length; i++) {
            if (!file[i].isDirectory())
            	flist.add(file[i]);
        }
    	int width= 100;
    	int height = 100;
    	boolean bb = false;
    	try {
    		for(int i=0;i<flist.size();i++){
    			double ratio = 0.0; // 缩放比例
                File f = flist.get(i);
                String filename = result + f.getName();
                BufferedImage bi = ImageIO.read(f);
                Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
                // 计算比例
                if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                    if (bi.getHeight() > bi.getWidth()) {
                        ratio = (new Integer(height)).doubleValue()
                                / bi.getHeight();
                    } else {
                        ratio = (new Integer(width)).doubleValue() / bi.getWidth();
                    }
                    AffineTransformOp op = new AffineTransformOp(AffineTransform
                            .getScaleInstance(ratio, ratio), null);
                    itemp = op.filter(bi, null);
                }
                if (bb) {//补白
                    BufferedImage image = new BufferedImage(width, height,
                            BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = image.createGraphics();
                    g.setColor(Color.white);
                    g.fillRect(0, 0, width, height);
                    if (width == itemp.getWidth(null))
                        g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                                itemp.getWidth(null), itemp.getHeight(null),
                                Color.white, null);
                    else
                        g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                                itemp.getWidth(null), itemp.getHeight(null),
                                Color.white, null);
                    g.dispose();
                    itemp = image;
                }
                ImageIO.write((BufferedImage) itemp, "JPEG", new File(filename));
                System.out.println("create 100x100 jpg file:"+filename);
    		}
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
	public static void convertsalemessage(){
    	String srcImageFile = "/home/ubuntu/lmmobilesite/lmmobilesite/public/images/salemessage/";
    	String result = "/home/ubuntu/lmmobilesite/public/images/salemessage/100x100/";
    	File dir = new File(srcImageFile);
    	File file[] = dir.listFiles();
    	List<File> flist = new ArrayList<File>(); 
    	for (int i = 0; i < file.length; i++) {
            if (!file[i].isDirectory())
            	flist.add(file[i]);
        }
    	int width= 100;
    	int height = 100;
    	boolean bb = false;
    	try {
    		for(int i=0;i<flist.size();i++){
    			double ratio = 0.0; // 缩放比例
                File f = flist.get(i);
                String filename = result + f.getName();
                BufferedImage bi = ImageIO.read(f);
                Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
                // 计算比例
                if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                    if (bi.getHeight() > bi.getWidth()) {
                        ratio = (new Integer(height)).doubleValue()
                                / bi.getHeight();
                    } else {
                        ratio = (new Integer(width)).doubleValue() / bi.getWidth();
                    }
                    AffineTransformOp op = new AffineTransformOp(AffineTransform
                            .getScaleInstance(ratio, ratio), null);
                    itemp = op.filter(bi, null);
                }
                if (bb) {//补白
                    BufferedImage image = new BufferedImage(width, height,
                            BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = image.createGraphics();
                    g.setColor(Color.white);
                    g.fillRect(0, 0, width, height);
                    if (width == itemp.getWidth(null))
                        g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                                itemp.getWidth(null), itemp.getHeight(null),
                                Color.white, null);
                    else
                        g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                                itemp.getWidth(null), itemp.getHeight(null),
                                Color.white, null);
                    g.dispose();
                    itemp = image;
                }
                ImageIO.write((BufferedImage) itemp, "JPEG", new File(filename));
                System.out.println("create 100x100 jpg file:"+filename);
    		}
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
	public static void main(String[] args) {
		convertteacher();
	}
}
