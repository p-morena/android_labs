package com.example.hbwitcher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
private int category, position;
private TextView text_content;
private ImageView image_content;

private int[] array_person = {R.string.person1,R.string.person2,R.string.person3,R.string.person4,R.string.person5,R.string.person6,R.string.person7,R.string.person8,R.string.person9};
private int[] array_monster = {R.string.monster1,R.string.monster2,R.string.monster3,R.string.monster4,R.string.monster5,R.string.monster6,R.string.monster7,R.string.monster8};
private int[] array_animal = {R.string.animal1,R.string.animal2,R.string.animal3};
private int[] array_elixir = {R.string.elixir1,R.string.elixir2,R.string.elixir3,R.string.elixir4,R.string.elixir5};
private int[] array_sword = {R.string.sword1,R.string.sword2,R.string.sword3,R.string.sword4,R.string.sword5};
private int[] array_magic = {R.string.magic1,R.string.magic2,R.string.magic3,R.string.magic4,R.string.magic5};

private int[] array_image_p = {R.drawable.avalkh,R.drawable.vesemir, R.drawable.geralt,R.drawable.eredin, R.drawable.dandelion,R.drawable.yennefer, R.drawable.priscilla, R.drawable.triss,   R.drawable.ciri};
private int[] array_image_m = {R.drawable.bes, R.drawable.doppler,R.drawable.korolevskaya_viverna, R.drawable.leshen,R.drawable.mglyak, R.drawable.poludenicy,R.drawable.pribojek, R.drawable.sirena};
private int[] array_image_a = {R.drawable.medved, R.drawable.wolf, R.drawable.dog};
private int[] array_image_e =  {R.drawable.b_medved, R.drawable.grom, R.drawable.koshka, R.drawable.lastochka, R.drawable.sova};
private int[] array_image_s={R.drawable.arbalet, R.drawable.gvestog, R.drawable.mech_dop_blan, R.drawable.mogrim_silver, R.drawable.moon_silver};
private int[] array_image_mag = {R.drawable.aard,R.drawable.aksel,R.drawable.igni,R.drawable.irden,R.drawable.quen};


private String []title_person = {"Авалакх","Весемир","Геральт","Єредін","Любисток","Йенефер","Присцилла","Трісс","Циріла"};
private String[] title_monstre = {"Біс","Доплер","Королівська віверна","Лісовик","Мгляк","Полуденка","Прибожок","Сирена"};
private String[] title_animal= {"Ведмідь","Волк","Собака"};
private String[] title_elixir= {"Білий ведмідь","Грім","Кішка","Ластівка","Сова"};
private String[] title_sword= {"Арбалет","Гвестог","Міч Дроп Блан","Могрим","Місячне срібло"};
private String[] title_magic = {"Знак Аард","Знак Аксій","Знак Квен","Знак Ігні","Знак Ірден"};








    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content= findViewById(R.id.text_main_content);
        image_content=findViewById(R.id.imageContent);

        reciveIntent();
    }

  public void  reciveIntent(){

      Intent i = getIntent();
      if(i!=null){
          category =i.getIntExtra("category", 0);
          position= i.getIntExtra("position", 0);
      }
      switch (category){
          case 0:
              text_content.setText(array_person[position]);
              image_content.setImageResource(array_image_p[position]);
              getSupportActionBar().setTitle(title_person[position]);

              break;

          case 1:
              text_content.setText(array_monster[position]);
              image_content.setImageResource(array_image_m[position]);
              getSupportActionBar().setTitle(title_monstre[position]);
              break;

          case 2:
              text_content.setText(array_animal[position]);
              image_content.setImageResource(array_image_a[position]);
              getSupportActionBar().setTitle(title_animal[position]);
              break;
          case 3:
              text_content.setText(array_elixir[position]);
              image_content.setImageResource(array_image_e[position]);
              getSupportActionBar().setTitle(title_elixir[position]);
              break;
          case 4:
              text_content.setText(array_sword[position]);
              image_content.setImageResource(array_image_s[position]);
              getSupportActionBar().setTitle(title_sword[position]);
              break;
          case 5:
              text_content.setText(array_magic[position]);
              image_content.setImageResource(array_image_mag[position]);
              getSupportActionBar().setTitle(title_magic[position]);
              break;

      }




    }
}
