package com.example.ddrawdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
	// �Ŵ���С
	private int bili = 200;

	// ����λ��
	private int drawX = 10;
	private int drawY = 20;
	// ����ͼ�η�Χ
	private int recWidth = 160;
	// ����͸����
	private int alpha = 255;
	// ����Բ�����λ��
	private int cx = 40;
	private int cy = 40;
	private int cr = 20;
	// ������Բ��λ�� ���
	private float ox = 110;
	private float oy = 30;
	private float ow = ox + 30;
	private float oh = oy + 20;

	private Paint paint;

	/**
	 * ��д����Ĺ��췽��
	 * 
	 * @param context
	 */
	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		paint = new Paint();
		paint.setAlpha(100);
	}

	@Override
	protected void onDraw(Canvas canvas) {
//		paint.setAlpha(100);
		// ������
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(5);
		canvas.drawRect(drawX, drawY, drawX + recWidth, drawY + recWidth, paint);
		// ��Բ
		paint.setColor(Color.BLACK);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(drawX + cx, drawY + cy, cr, paint);
		// ����Բ
		canvas.drawOval(new RectF(drawX + ox, drawY + oy, drawX + ow, drawY
				+ oh), paint);
		// ������
		Path path = new Path();
		path.moveTo(drawX + 80, drawY + 70);
		path.lineTo(drawX + 60, drawY + 90);
		path.lineTo(drawX + 100, drawY + 90);
		path.close();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.BLUE);
		canvas.drawPath(path, paint);
		// ������
		canvas.drawArc(new RectF(drawX + 40, drawY + 30, drawX + 120,
				drawY + 110), 30, 120, false, paint);
		// ����ɫʵ�ľ���
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		canvas.drawRect(drawX + 30, drawY + 120, drawX + 120, drawY + 140,
				paint);
		super.onDraw(canvas);
	}

	/**
	 * ��д���������¼�
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * ��д����̧���¼�
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		return super.onKeyUp(keyCode, event);
	}

	/**
	 * ��д�����¼�����
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
			alpha = 100;
			paint.setAlpha(alpha);
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			alpha = 255;
			paint.setAlpha(alpha);
			invalidate();
			break;
		}
		int x = (int) event.getX();
		int y = (int) event.getY();
		drawX = x;
		drawY = y;
		invalidate();
		return true;
	}

}
