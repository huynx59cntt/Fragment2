package vn.edu.ntu.xuanhuy.fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

import vn.edu.ntu.xuanhuy.IController.IController;
import vn.edu.ntu.xuanhuy.model.Product;

public class ShoppingCart extends Fragment {
    TextView txtGH;
    Button btn1, btn2;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtGH = view.findViewById(R.id.txtGH);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển layout shopping qua layout confirm
               NavHostFragment.findNavController(ShoppingCart.this)
                       .navigate(R.id.action_shoppingCart_to_confirm);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IController controller = (IController) getActivity().getApplication();
                controller.clearShopping();
                txtGH.setText("");
                Toast.makeText(getActivity(), "Đã xoa giò hàng" , Toast.LENGTH_SHORT).show();
            }
        });
        ViewCartInfo();
    }
    private  void ViewCartInfo(){
        IController controller = (IController) getActivity().getApplication();
        ArrayList<Product> listproduct = controller.listShopping();
        StringBuilder builder = new StringBuilder();

        for(Product p : listproduct)
            builder.append(p.getName() + ": \t\t" + p.getPrice() + " VND\n");

        txtGH.setText(builder.toString());
    }
}
