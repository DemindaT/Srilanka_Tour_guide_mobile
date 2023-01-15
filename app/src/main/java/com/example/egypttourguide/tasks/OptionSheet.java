package com.example.egypttourguide.tasks;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.egypttourguide.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class OptionSheet {
    public  interface  IBottomSheet{
        public void  onOptionClicked(int option);


    }

    public  static void  showOption(Activity con,IBottomSheet callBack)
    {
        BottomSheetDialog dialog =new  BottomSheetDialog(con);
         View view = con.getLayoutInflater().inflate(R.layout.bottom_sheet, null);
         View  close=view.findViewById(R.id.close);
            TextView AC1=(TextView)view.findViewById(R.id.a1);
            TextView  AC2=(TextView)view.findViewById(R.id.a2);
            TextView  title=(TextView)view.findViewById(R.id.title);
            title.setText("More");
        AC1.setText("Edit");
        AC2.setText("Delete");
        AC2.setTextColor(con.getColor(R.color.colortext));
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        AC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onOptionClicked(1);
                dialog.dismiss();
            }
        });

        AC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onOptionClicked(2);
                dialog.dismiss();
            }
        });



        dialog.setCancelable(false);
        dialog.setContentView(view);
        dialog.show();
    }


}
