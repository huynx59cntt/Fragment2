package vn.edu.ntu.xuanhuy.fragment2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.ntu.xuanhuy.IController.IController;
import vn.edu.ntu.xuanhuy.model.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class Product1 extends Fragment {

    public Product1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText edtName, edtPrice, edtDesc;
        Button btnThem;

        edtName = view.findViewById(R.id.edtName);
        edtPrice = view.findViewById(R.id.edtPrice);
        edtDesc = view.findViewById(R.id.edtDesc);
        btnThem = view.findViewById(R.id.btnThem);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IController controller = (IController) getActivity().getApplication();
                Product  p = new Product(edtName.getText().toString(), new Integer(edtPrice.getText().toString()),
                        edtDesc.getText().toString());
                controller.listProduct().add(p);
                Toast.makeText(getActivity(), "Đã thêm" + edtName.getText() + " vào giỏ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
