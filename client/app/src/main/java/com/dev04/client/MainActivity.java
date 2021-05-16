package com.dev04.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.dev04.client.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 어플리케이션 실행시 LoginFragment를 실행하여 화면을 구성
        navigateTo(new LoginFragment(), false);
    }

    // 프라그먼트를 오고갈 메소드 선언
    public void navigateTo(Fragment fragment, boolean addToBackStack) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
    }
}
