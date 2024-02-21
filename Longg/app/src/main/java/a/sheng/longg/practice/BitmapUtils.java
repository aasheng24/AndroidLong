package a.sheng.longg.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.renderscript.ScriptGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import a.sheng.longg.R;

public class BitmapUtils {

    private void testApi() {

    }

    private void testOptions() {
        String path = "";

        //压缩图片
        BitmapFactory.Options options1 = new BitmapFactory.Options();
        options1.inSampleSize = 2; //压缩到1/2
        Bitmap bitmap = BitmapFactory.decodeFile(path,options1);

        //低内存获取图片宽高
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        Bitmap bitmap1 = BitmapFactory.decodeFile(path,options2);
        int width = bitmap1.getWidth();
        int height = bitmap1.getHeight();

        //改变编码格式
        BitmapFactory.Options options3 = new BitmapFactory.Options();
        options3.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap2 = BitmapFactory.decodeFile(path, options3);

    }

    private void testRegion(Context context) throws IOException {
        //Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bitmap_test);
        InputStream inputStream = context.getAssets().open("bitmap_test.png");
        BitmapRegionDecoder decoder = null;
        try {
            decoder = BitmapRegionDecoder.newInstance(inputStream, false);

            // 指定要解码和显示的区域
            Rect rect = new Rect(100, 100, 300, 300); // 区域的左上角和右下角坐标
            Bitmap regionBitmap = decoder.decodeRegion(rect, null);

            // 在ImageView中显示解码后的位图
//            ImageView imageView = findViewById(R.id.imageView);
//            imageView.setImageBitmap(regionBitmap);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (decoder != null) {
                decoder.recycle();
            }
        }
    }
}
