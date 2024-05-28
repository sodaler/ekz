package com.example.examtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DbList db;
    ListFragment lst_frag;
    PortsFragment ports_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst_frag = ListFragment.newInstance();
        ports_frag = PortsFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.lstFrag_cont, lst_frag)
                .commit();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.portsFrag_cont, ports_frag)
                .commit();

        db = DbList.getInstance();
    }

    ModelFragment current;
    FilterFragment currentFltr;
    View.OnClickListener modelDlg_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_enter) {
                try {
                    int age = Integer.parseInt(current.fld_age.getText().toString());
                    if (current.nw) lst_frag.add(current.fld_name.getText().toString(), age);
                    else lst_frag.edit(current.fld_name.getText().toString(), age);
                }
                catch (Exception ex) {
                    Log.w("err", "parse error");
                }
            }
            current.dismiss();
            current = null;
        }
    };
    View.OnClickListener filterDlg_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_enter) {
                try {
                    String opt = currentFltr.getSelected();
                    int age = Integer.parseInt(currentFltr.fld_age.getText().toString());
                    Intent intent = new Intent(MainActivity.this, ReportActivity.class);
                    intent.putExtra("opt", opt);
                    intent.putExtra("age", age);
                    startActivity(intent);
                }
                catch (Exception ex) {
                    Log.w("err", "parse error");
                }
            }
            currentFltr.dismiss();
            currentFltr = null;
        }
    };

    @Override
    public void onClick(View v) {
        int v_id = v.getId();
        if (v_id == R.id.btn_add) {
            current = ModelFragment.newInstance(modelDlg_listener);
            current.show(getSupportFragmentManager(), "m_dlg");
        }
        if (v_id == R.id.btn_edit) {
            if (lst_frag.getSelected() == null) return;
            current = ModelFragment.newInstance(
                    lst_frag.getSelected(),
                    db.getByName(lst_frag.getSelected()).age,
                    modelDlg_listener
            );
            current.show(getSupportFragmentManager(), "m_dlg");
        }
        if (v_id == R.id.btn_delete) {
            lst_frag.delete();
        }
        if (v_id == R.id.btn_report) {
            currentFltr = FilterFragment.newInstance(filterDlg_listener);
            currentFltr.show(getSupportFragmentManager(), "f_dlg");
        }
    }

}