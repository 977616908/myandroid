package com.ifidc.traffic.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundImageView extends ImageView {

	private Context context;
	public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public RoundImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context=context;
	}

	public RoundImageView(Context context) {
		super(context);
	}

	

	@Override
	public void setBackgroundDrawable(Drawable background) {
		// TODO Auto-generated method stub)
		super.setBackgroundDrawable(toRoundCorner(background));
	}

	@Override
	public void setBackgroundResource(int resid) {
		// TODO Auto-generated method stub
		setBackgroundDrawable(toRoundCorner(context.getResources().getDrawable(resid)));
	}

	public static Drawable toRoundCorner(Drawable drawable) {
		BitmapDrawable drawle = (BitmapDrawable) drawable;
		Bitmap bitmap = drawle.getBitmap();
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG
				| Paint.FILTER_BITMAP_FLAG));

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		paint.setAntiAlias(true);
		paint.setFilterBitmap(true);
		canvas.drawARGB(0, 0, 0, 0);

		paint.setColor(color);
		  canvas.drawRoundRect(rectF, bitmap.getWidth()/2, 
                  bitmap.getHeight()/2, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		BitmapDrawable redrawle = new BitmapDrawable(output);

		return redrawle;
	}

}
