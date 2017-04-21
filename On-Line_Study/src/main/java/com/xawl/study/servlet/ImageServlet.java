package com.xawl.study.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
	  public static final int WIDTH=120;
	     public static final int HEIGHT=35;

	   //输出一张随机图片
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
	            BufferedImage image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	            Graphics g=image.getGraphics();
	            //1,设置背景
	            setBackGround(g);
	            //response.setHeader(arg0, arg1);
	            setBorder(g);
	            drowRandomLine(g);
	            String random=drowRandNum((Graphics2D)g);
	            request.getSession().setAttribute("random", random);
	            response.setContentType("image/jpeg");
	            ImageIO.write(image,"jpg",response.getOutputStream());
	            //Image .write(image,"jpg",response.getOutputStream());
		}

		private String drowRandNum(Graphics2D g) {
			// TODO Auto-generated method stub
			g.setColor(Color.red);
			String base="123434564565473586579869743";
			g.setFont(new Font("宋体",Font.BOLD,20));
			int x=5;
			StringBuffer sb=new StringBuffer();
			for (int i = 0; i < 4; i++) {
				int degree =new Random().nextInt()%30;
				String ch=base.charAt(new Random().nextInt(base.length()))+"";
				sb.append(ch);
				 g.rotate(degree*Math.PI/180,x,20);
				       g.drawString(ch, x, 20);
				g.rotate(-degree*Math.PI/180,x,20);
				x+=30;
		       
			}
			return sb.toString();
		}

		private void drowRandomLine(Graphics g) {
			// TODO Auto-generated method stub
			g.setColor(Color.GREEN);
			for (int i = 0; i < 10; i++) {
				int x1=new Random().nextInt(WIDTH);
				int y1=new Random().nextInt(HEIGHT);
				int x2=new Random().nextInt(WIDTH);
				int y2=new Random().nextInt(HEIGHT);
				g.drawLine(x1, y1, x2, y2);
			}
		}

		private void setBorder(Graphics g) {
			// TODO Auto-generated method stub
			g.setColor(Color.blue);
			g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
		}

		private void setBackGround(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		doGet(request, response);
		}
}
