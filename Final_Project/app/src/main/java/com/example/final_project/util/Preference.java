package com.example.final_project.util;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preference {
    static final  String tokend = "TOKEN";
    static final  String named = "NAME";
    static  final String niked = "NIK";
    static final String idnasabah ="id";


    private static SharedPreferences getSharedPreferences (Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    public static  void  setToken (Context context, String token){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString( tokend, token);
        editor.apply();
    }

    public static  String getToken(Context context){
        return getSharedPreferences(context).getString(tokend,"");
    }

    public static  void  setName (Context context, String name){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString( named, name);
        editor.apply();
    }

    public static  String getName(Context context){
        return getSharedPreferences(context).getString(named,"");
    }

    public static  void  setNik (Context context, String nik){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString( niked, nik);
        editor.apply();
    }

    public static  String getNik(Context context){
        return getSharedPreferences(context).getString(niked,"");
    }
    public static  void  setIdnasabah (Context context, String id){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString( idnasabah, id);
        editor.apply();
    }

    public static  String getIdnasabah(Context context){
        return getSharedPreferences(context).getString(idnasabah,"");
    }
}

