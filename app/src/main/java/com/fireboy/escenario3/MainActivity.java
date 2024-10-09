package com.fireboy.escenario3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SwitchCompat swcInformatica;
    Spinner spInfo;
    RadioGroup rgOpciones;
    ArrayList<RadioButton> rbOpciones = new ArrayList<>();
    ArrayList<String> opciones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swcInformatica = findViewById(R.id.swcInformatica);
        spInfo = findViewById(R.id.spInfo);
        rgOpciones = findViewById(R.id.rgOpciones);
        rbOpciones.add(findViewById(R.id.rbOpciones1));
        rbOpciones.add(findViewById(R.id.rbOpciones2));
        rbOpciones.add(findViewById(R.id.rbOpciones3));

        opciones.add(getString(R.string.dam));
        opciones.add(getString(R.string.daw));
        opciones.add(getString(R.string.asir));

        spInfo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones));

        swcInformatica.setOnCheckedChangeListener((compoundButton, b) -> activarSpinner(b));

        spInfo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spInfo.getVisibility() == View.VISIBLE) {
                    i++;
                    actualizarTexto(i);
                } else {
                    actualizarTexto(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void activarSpinner(boolean b) {
        if (b) {
            switch (spInfo.getSelectedItem().toString()) {
                case "DAM":
                    actualizarTexto(1);
                    break;
                case "DAW":
                    actualizarTexto(2);
                    break;
                case "ASIR":
                    actualizarTexto(3);
                    break;
            }

            spInfo.setVisibility(View.VISIBLE);
        } else {
            actualizarTexto(0);

            spInfo.setVisibility(View.INVISIBLE);
        }
    }

    private void actualizarTexto(int tipo) {
        switch (tipo) {
            case 0:
                rbOpciones.get(0).setText(getString(R.string.matematicas));
                rbOpciones.get(1).setText(getString(R.string.biologia));
                rbOpciones.get(2).setText(getString(R.string.fisica_y_quimica));
                break;
            case 1:
                rbOpciones.get(0).setText(getString(R.string.pmdm));
                rbOpciones.get(1).setText(getString(R.string.psp));
                rbOpciones.get(2).setText(getString(R.string.di));
                break;
            case 2:
                rbOpciones.get(0).setText(getString(R.string.dwec));
                rbOpciones.get(1).setText(getString(R.string.dwes));
                rbOpciones.get(2).setText(getString(R.string.diw));
                break;
            case 3:
                rbOpciones.get(0).setText(getString(R.string.aso));
                rbOpciones.get(1).setText(getString(R.string.sad));
                rbOpciones.get(2).setText(getString(R.string.sri));
                break;
        }
    }
}