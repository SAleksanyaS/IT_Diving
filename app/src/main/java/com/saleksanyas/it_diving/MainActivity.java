package com.saleksanyas.it_diving;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private  Toast backToast;
    boolean isPlay = true;
    boolean isPlay_1 = true;
    boolean isPlay_2 = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Объявление кнопок
        ImageButton camera_button = (ImageButton) findViewById(R.id.camera_button);
        ImageButton micro_button = (ImageButton) findViewById(R.id.micro_button);
        ImageButton hand_button = (ImageButton) findViewById(R.id.hand_button);
        ImageButton phone_button = (ImageButton) findViewById(R.id.phone_button);
        ImageButton barrier_top = (ImageButton) findViewById(R.id.barrier_top);
        ImageButton message = (ImageButton) findViewById(R.id.messager);
        ImageButton contact_list = (ImageButton) findViewById(R.id.contact_list);
        ImageButton switch_photo = (ImageButton) findViewById(R.id.switch_photo);

        ImageView interlocutor_1 = (ImageView) findViewById(R.id.interlocutor_1);
        ImageView interlocutor_2 = (ImageView) findViewById(R.id.interlocutor_2);
        ImageView interlocutor_pikcha_1 = (ImageView) findViewById(R.id.interlocutor_pikcha_1);
        ImageView interlocutor_pikcha_2 = (ImageView) findViewById(R.id.interlocutor_pikcha_2);

        TextView interlocutor_text_1 = (TextView) findViewById(R.id.interlocutor_text_1);
        TextView interlocutor_text_2 = (TextView) findViewById(R.id.interlocutor_text_2);
        ImageView interlocutor_camera_1 = (ImageView) findViewById(R.id.interlocutor_camera_1);
        ImageView interlocutor_camera_2 = (ImageView) findViewById(R.id.interlocutor_camera_2);

        // выход из приложения
        phone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        // изменение камеры
        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlay_2 && isPlay){
                    isPlay_2 = false;
                    camera_button.setImageResource(R.drawable.ic_camera_mute);
                    interlocutor_camera_1.setImageResource(R.drawable.ic_camera_mute_mini);
                    interlocutor_camera_2.setImageResource(R.drawable.ic_camera_mute_mini);
                }


                else if(isPlay_2 && !(isPlay)){
                    isPlay_2 = false;
                    camera_button.setImageResource(R.drawable.ic_camera_mute);
                    interlocutor_camera_1.setImageResource(R.drawable.ic_camera_mute_mini);
                    interlocutor_camera_2.setImageResource(R.drawable.ic_camera_mute_mini);
                }


                else if(!(isPlay_2) && isPlay){
                    isPlay_2 = true;
                    camera_button.setImageResource(R.drawable.ic_camera);
                    interlocutor_camera_1.setImageResource(R.drawable.ic_camera_mini);
                    interlocutor_camera_2.setImageResource(R.drawable.ic_camera_mute_mini);
                }


                else if(!(isPlay_2) && !(isPlay)){
                    isPlay_2 = true;
                    camera_button.setImageResource(R.drawable.ic_camera);
                    interlocutor_camera_2.setImageResource(R.drawable.ic_camera_mini);
                    interlocutor_camera_1.setImageResource(R.drawable.ic_camera_mute_mini);
                }
            }
        });


        // изменение микрофона
        micro_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlay_1 && isPlay){
                    isPlay_1 = false;
                    micro_button.setImageResource(R.drawable.ic_micro_mute);
                    interlocutor_text_1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);
                    interlocutor_text_2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);
                }


                else if(isPlay_1 && !(isPlay)){
                    isPlay_1 = false;
                    micro_button.setImageResource(R.drawable.ic_micro_mute);
                    interlocutor_text_1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);
                    interlocutor_text_2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);
                }


                else if(!(isPlay_1) && isPlay){
                    isPlay_1 = true;
                    micro_button.setImageResource(R.drawable.ic_micro);
                    interlocutor_text_1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mini, 0);
                    interlocutor_text_2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);
                }


                else if(!(isPlay_1) && !(isPlay)){
                    isPlay_1 = true;
                    micro_button.setImageResource(R.drawable.ic_micro);
                    interlocutor_text_2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mini, 0);
                    interlocutor_text_1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);
                }

            }
        });


        // AlertDialog
        hand_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this );
                TextView myMsg = new TextView(MainActivity.this);
                builder.setCustomTitle(myMsg);
                builder.setMessage("привет");
                builder.setPositiveButton("Х", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.show();
                TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
                messageText.setGravity(Gravity.CENTER);

                // автоматическое закрытие через 3 секунды
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        dialog.dismiss();
                        timer.cancel();
                    }
                }, 3000);
            }
        });


        // переход в SMS
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setData(Uri.parse("sms:"));
                    startActivity(sendIntent);
                }
                catch (Exception e){
                }
            }

        });


        // переход в список контактов
        contact_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"));
                    startActivity(intent);

                } catch (Exception e){
                }
            }
        });


        // Виджет
        switch_photo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if(isPlay){
                    isPlay = false;
                    interlocutor_1.setBackgroundColor(getResources().getColor(R.color.teal_700));
                    interlocutor_2.setBackgroundColor(getResources().getColor(R.color.teal_200));

                    interlocutor_pikcha_1.setImageResource(R.drawable.wombat);
                    interlocutor_pikcha_2.setImageResource(R.drawable.capi);

                    interlocutor_text_1.setText(R.string.text_2);
                    interlocutor_text_2.setText(R.string.text_1);


                    interlocutor_text_1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);

                    if(isPlay_1){
                        interlocutor_text_2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mini, 0);
                    }
                    else{
                        interlocutor_text_2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);
                    }

                    interlocutor_camera_1.setImageResource(R.drawable.ic_camera_mute_mini);

                    if(isPlay_2){
                        interlocutor_camera_2.setImageResource(R.drawable.ic_camera_mini);
                    }
                    else{
                        interlocutor_camera_2.setImageResource(R.drawable.ic_camera_mute_mini);
                    }

                }else{
                    isPlay = true;
                    interlocutor_1.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    interlocutor_2.setBackgroundColor(getResources().getColor(R.color.teal_700));

                    interlocutor_pikcha_1.setImageResource(R.drawable.capi);
                    interlocutor_pikcha_2.setImageResource(R.drawable.wombat);
                    interlocutor_text_1.setText(R.string.text_1);
                    interlocutor_text_2.setText(R.string.text_2);

                    interlocutor_text_2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);

                    if(isPlay_1){
                        interlocutor_text_1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mini, 0);
                    }
                    else{
                        interlocutor_text_1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_micro_mute_mini, 0);
                    }

                    interlocutor_camera_2.setImageResource(R.drawable.ic_camera_mute_mini);

                    if(isPlay_2){
                        interlocutor_camera_1.setImageResource(R.drawable.ic_camera_mini);
                    }
                    else{
                        interlocutor_camera_1.setImageResource(R.drawable.ic_camera_mute_mini);
                    }

                }
            }
        });



    }


    // Системная Кнопка "Назад"
    @Override
    public void onBackPressed(){
        if(backPressedTime + 3000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else{
            backToast = Toast.makeText(getBaseContext(), getText(R.string.exitt),Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}