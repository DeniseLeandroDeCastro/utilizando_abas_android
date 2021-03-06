package br.edu.ifrn.utilizandoabas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.edu.ifrn.utilizandoabas.fragment.EmAltaFragment;
import br.edu.ifrn.utilizandoabas.fragment.HomeFragment;
import br.edu.ifrn.utilizandoabas.fragment.InscricoesFragment;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        //Para remover a sombra do actionBar
        getSupportActionBar().setElevation(0);

        //Configurar um adapter para as abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class)
                        .add("Inscrições", InscricoesFragment.class)
                        .add("Em Alta", EmAltaFragment.class)
                .create()
        );
        //Configurando o viewPager
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}