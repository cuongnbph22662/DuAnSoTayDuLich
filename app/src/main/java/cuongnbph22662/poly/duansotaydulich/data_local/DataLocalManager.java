package cuongnbph22662.poly.duansotaydulich.data_local;

import android.content.Context;

public class DataLocalManager {
    private static final String PREF_FIRST_INSTALL = "PREF_FIRST_INSTALL";
    private static DataLocalManager instance;
    private MySharePreferences mySharePreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharePreferences = new MySharePreferences(context);
    }

    public static DataLocalManager getInstance(){
        if(instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }


    public static void setLanDauVaoApp(Boolean isFirst){
        DataLocalManager.getInstance().mySharePreferences.putBooleanValue(PREF_FIRST_INSTALL, isFirst);
    }

    public static boolean getLanDauVaoApp(){
        return DataLocalManager.getInstance().mySharePreferences.getBooleanValue(PREF_FIRST_INSTALL);
    }

    public static void setTrangThaiDangNhap(Boolean isFirst){
        DataLocalManager.getInstance().mySharePreferences.putTrangThai(PREF_FIRST_INSTALL, isFirst);
    }

    public static boolean layTrangThaiDangNhap(){
        return DataLocalManager.getInstance().mySharePreferences.getTrangThai(PREF_FIRST_INSTALL);
    }
}
