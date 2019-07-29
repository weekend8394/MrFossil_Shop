package com.example.mrfossil_shop.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.model.ShopProduct;


public class AddshoppingCartDialog extends Dialog {
    private ImageView ivHeadView;
    private TextView tvPrice,tvProductName,tvCounter;
    private Button btAdd,btCut,btOk;
    private ShopProduct mProductInfo;
    private int counter = 1;

    public AddshoppingCartDialog(Context context, ShopProduct productInfo) {
        super(context,R.style.ActionSheetDialogStyle);
        this.mProductInfo = productInfo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_addshoppingcart);
        ivHeadView = findViewById(R.id.iv_HeadView);
        tvPrice = findViewById(R.id.tv_Price);
        tvProductName = findViewById(R.id.tv_ProductName);
        tvCounter = findViewById(R.id.tv_Counter);
        btAdd = findViewById(R.id.bt_add);
        btCut = findViewById(R.id.bt_cut);
        btOk = findViewById(R.id.bt_ok);

        ivHeadView.setImageResource(mProductInfo.getImageRes());
        tvPrice.setText("單價 : $ " + mProductInfo.getPrice() + "元");
        tvProductName.setText(mProductInfo.getProductName());

        btCut.setEnabled(false);
        btCut.setTextColor(getContext().getResources().getColor(R.color.gray_dcdce4));

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btCut.setEnabled(true);
                btCut.setTextColor(getContext().getResources().getColor(R.color.black));
                counter = counter + 1 ;
                tvCounter.setText("" + counter);
            }
        });

        btCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvCounter.getText().equals("2")){
                    btCut.setEnabled(false);
                    btCut.setTextColor(getContext().getResources().getColor(R.color.gray_dcdce4));
                    counter = counter - 1;
                    tvCounter.setText("" + counter);
                }else {
                    counter = counter - 1;
                    tvCounter.setText("" + counter);
                }
            }
        });

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                dismiss();
            }
        });
    }


    @Override
    public void show() {
        super.show();

        if(getWindow() != null){
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            getWindow().setAttributes(params);
            getWindow().setGravity(Gravity.BOTTOM);
            setCanceledOnTouchOutside(true);
        }
    }
}
