package cn.edu.scnu.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ��֤��
 */
@Controller
public class ValiImage {
	// {"����", "���Ŀ���", "����", "������κ", "��������", "΢���ź�", "����_GB2312"}
		private static String[] fontNames = { "����", "���Ŀ���", "����", "΢���ź�",  "����_GB2312" };
		// ��ѡ�ַ�
		//"23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
		private static String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
		// ����ɫ
		private Color bgColor = new Color(255, 255, 255);
		// ����(һ��������ռ�Ŀռ��С)
		private int base = 30;
		// ͼ����
		private int width = base * 4;
		// ͼ��߶�
		private int height = base;
		// ���ָ���
		private int len = 4;
		// ���������С
		private int fontSize = 22;
		
		private BufferedImage img = null;
		private Graphics2D g2 = null;

		@RequestMapping("/index/valiImage")
		public void validateCode(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			// ������Ӧ��ͷ��Ϣ
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			// ������Ӧ��MIME����
			response.setContentType("image/jpeg");

		
			// 1.����ͼƬ����������, �����ÿ�ߺ�ͼ������
			img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			// 2.�õ����ƻ���
			g2 = (Graphics2D) img.getGraphics();
			// 3.��ʼ��ͼ
			// ���ñ���ɫ
			g2.setColor(bgColor);
			g2.fillRect(0, 0, width, height);
			
			StringBuffer sb = new StringBuffer();// ����װ����֤���ϵ��ı�

			for (int i = 0; i < len; i++) {
				// ���û�����ɫ -- ���
				// g2.setColor(new Color(255, 0, 0));
				g2.setColor(new Color(getRandom(0, 150), getRandom(0, 150),getRandom(0, 150)));

				// ��������
				g2.setFont(new Font(fontNames[getRandom(0, fontNames.length)], Font.BOLD, fontSize));

				// ��ת����(-45~+45)
				int theta = getRandom(-45, 45);
				g2.rotate(theta * Math.PI / 180, 7 + i * base, height - 8);

				// д��
				String code = codes.charAt(getRandom(0, codes.length())) + "";
				g2.drawString(code, 7 + i * base, height - 8);
				sb.append(code);
				g2.rotate(-theta * Math.PI / 180, 7 + i * base, height - 8);
			}
			
			

			// ��������
			for (int i = 0; i < len + 2; i++) {
				// ���û�����ɫ -- ���
				// g2.setColor(new Color(255, 0, 0));
				g2.setColor(new Color(getRandom(0, 150), getRandom(0, 150),
						getRandom(0, 150)));
				g2.drawLine(getRandom(0, 120), getRandom(0, 30), getRandom(0, 120),
						getRandom(0, 30));
			}
			g2.setColor(Color.gray);
			g2.drawRect(0, 0, width-1,height-1);

			
			
			HttpSession se = request.getSession();
			se.setAttribute("code", null);
			se.setAttribute("code", sb.toString());


			// �ͷ�ͼ����Դ
			g2.dispose();
			try {
				OutputStream os = response.getOutputStream();
				// ���ͼ��ҳ��
				ImageIO.write(img, "JPEG", os);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		/*
		 * ����������ķ���
		 */
		private static int getRandom(int start, int end) {
			Random random = new Random();
			return random.nextInt(end - start) + start;
		}
}
