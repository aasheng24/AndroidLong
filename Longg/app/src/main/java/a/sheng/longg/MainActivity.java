package a.sheng.longg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import a.sheng.longg.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
    private void testDatabase() {
        //创建数据库
        SQLiteDatabase sq = this.openOrCreateDatabase("test.db", Context.MODE_PRIVATE,null);
        sq.execSQL("CREATE TABLE IF NOT EXISTS students(name VARCHAR, age int,sex VARCHAR)");

        //插入数据
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","tom");
        contentValues.put("age",20);
        contentValues.put("sex","male");
        sq.insert("students",null,contentValues);

        //查询数据
        Cursor cursor = sq.query("students",new String[]{"name","age","sex"},null,null,null,null,"ageASC");
        while(cursor.moveToNext()) {

        }
        cursor.close();

        //改
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("age",22);
        sq.update("student",contentValues1,"name=?",new String[]{"tom"});

        //删
        sq.delete("students","name=?",new String[]{"tom"});

        //关闭链接
        sq.close();
    }
}