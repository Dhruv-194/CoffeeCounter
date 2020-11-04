package com.example.android.justjava;

import android.os.Bundle;
import android.support.v4.app.RemoteActionCompatParcelizer;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Increament(View view) {
     if(quantity==100){
         return;
     }
        quantity = quantity + 1;
        display(quantity);

    }
    public void decreament(View view) {
    if(quantity==1){
        return;
    }
        quantity = quantity - 1;
        display(quantity);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField =(EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("MainActivity","Name:"+name);
        CheckBox WhippedCreamCheckBox =(CheckBox) findViewById(R.id.Whipped_cream_checkBox);
        boolean hasWhippedCream = WhippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.Chocolate_checkBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("MainActivity","Has whipped cream" + hasWhippedCream);
        Log.v("MainActivity","Has chocolate" +hasChocolate);

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage=createOrderSummary(name,price,hasWhippedCream,hasChocolate);
     displayMessage(priceMessage);

    }





    private int calculatePrice(boolean addWhippedCream,boolean addChocolate){
        int baseprice =5;
        if(addWhippedCream){
            baseprice =baseprice +1;
        }
         if(addChocolate){
            baseprice= baseprice + 2;
        }

        return quantity*baseprice;
    }

    private String createOrderSummary(String name,int price,boolean addWhippedCream,boolean addChocolate ){
        String priceMessage="Name:" + name;
          priceMessage+="\nAdd Whipped Cream?" + addWhippedCream;
          priceMessage+="\nAdd Chocolate?" + addChocolate;
           priceMessage +=  "\nQuantity:" + quantity;
               priceMessage+=   "\nTotal: $"+ price;
        priceMessage+=  "\nThankyou!";
        return priceMessage;
    }




   /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        OrderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}

