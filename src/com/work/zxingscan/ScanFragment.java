package com.work.zxingscan;

import com.google.zxing.WriterException;
import com.work.zxingscan.R;
import com.zbar.lib.decode.EncodingHandler;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * 生成模式 可以把输入的 文字或者图片转换成二维码显示  有个按键可以分享到 微博、微信朋友圈、微信好友、qq
*/

public class ScanFragment extends Fragment implements View.OnClickListener {
	EditText editText;
	ImageView img;
	private DisplayMetrics metrics;
	int width = 400;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View vontainView = inflater.inflate(R.layout.activity_secound, null);
		vontainView.findViewById(R.id.button1).setOnClickListener(this);
		editText = (EditText) vontainView.findViewById(R.id.editText1);
		img = (ImageView) vontainView.findViewById(R.id.imageView1);
		img.setScaleType(ScaleType.FIT_XY);
		metrics = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay()
				.getMetrics(metrics);
		width = (metrics.widthPixels * 2) / 3;
		return vontainView;

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.button1:
			String str = editText.getText().toString();
			if (str != null && str.trim().length() > 0) {
				try {
					Bitmap qrCodeBitmap = EncodingHandler.createQRCode(str,width);
					img.setImageBitmap(qrCodeBitmap);
				} catch (WriterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		}
	}
    /*private static final int IMAGE_HALFWIDTH = 20;
    // 显示二维码图片
    private ImageView imageview;
    // 插入到二维码里面的图片对象
    private Bitmap mBitmap;
    // 需要插图图片的大小 这里设定为40*40
    int[] pixels = new int[2*IMAGE_HALFWIDTH * 2*IMAGE_HALFWIDTH];
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        // 构造对象
        imageview = new ImageView(this);
        // 构造需要插入的图片对象
        mBitmap = ((BitmapDrawable) getResources().getDrawable(
                R.drawable.ic_launcher)).getBitmap();
        // 缩放图片
        Matrix m = new Matrix();
        float sx = (float) 2*IMAGE_HALFWIDTH / mBitmap.getWidth();
        float sy = (float) 2*IMAGE_HALFWIDTH / mBitmap.getHeight();
        m.setScale(sx, sy);
        // 重新构造一个40*40的图片
        mBitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(),
                mBitmap.getHeight(), m, false);
        try {
            //这里的string最好提到外面，写成QRcode生成的输入参数，这样更普适；
            String s = "仿微信二维码名片";
            imageview.setImageBitmap(cretaeBitmap(new String(s.getBytes(),
                    "ISO-8859-1")));
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        setContentView(imageview);
    }
    *//**
     * 生成二维码
     * 
     * @param 字符串
     * @return Bitmap
     * @throws WriterException
     *//*
    public Bitmap cretaeBitmap(String str) throws WriterException {
 
        // 生成二维矩阵,编码时指定大小,不要生成了图片以后再进行缩放,这样会模糊导致识别失败
        BitMatrix matrix = new MultiFormatWriter().encode(str,
                BarcodeFormat.QR_CODE, 300, 300);//如果要指定二维码的边框以及容错率，最好给encode方法增加一个参数：hints 一个Hashmap
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        // 二维矩阵转为一维像素数组,也就是一直横着排了
        int halfW = width / 2;
        int halfH = height / 2;
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x > halfW - IMAGE_HALFWIDTH && x < halfW + IMAGE_HALFWIDTH && y > halfH - IMAGE_HALFWIDTH
                        && y < halfH + IMAGE_HALFWIDTH) {
                    pixels[y * width + x] = mBitmap.getPixel(x - halfW + IMAGE_HALFWIDTH, y
                            - halfH + IMAGE_HALFWIDTH);
                } else {
                    //此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
                    pixels[y * width + x] = matrix.get(x, y)?0xff000000:0xfffffff;
                }
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        // 通过像素数组生成bitmap
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }*/
}