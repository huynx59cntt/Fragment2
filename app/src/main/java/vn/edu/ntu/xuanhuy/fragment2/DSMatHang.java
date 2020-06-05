package vn.edu.ntu.xuanhuy.fragment2;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import vn.edu.ntu.xuanhuy.IController.IController;
import vn.edu.ntu.xuanhuy.model.Product;

public class DSMatHang extends Fragment {
    RecyclerView rvListMH;
    FloatingActionButton fab;
    NavController controller ;


    IController iController;
    ArrayList<Product> listproduct;
    ProductADapter productADapter;
    //set menu
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_first,container, false);

        fab = view.findViewById(R.id.fab);

        rvListMH = view.findViewById(R.id.rvListMH);
        iController = (IController) getActivity().getApplication();
        listproduct = iController.listProduct();
        productADapter = new ProductADapter(listproduct);
        rvListMH.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvListMH.setAdapter(productADapter);
        // Inflate the layout for this fragment
        return view;
    }
//thêm giỏ menu giỏ hàng
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.mnu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
       if(id == R.id.mnucart)
       {
           CallShoppingFagment();
       }
        return super.onOptionsItemSelected(item);
    }
    private void CallShoppingFagment(){
        NavController controller = NavHostFragment.findNavController(DSMatHang.this);
        controller.navigate(R.id.action_DSMatHang_to_shoppingCart);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      //thiếu context nên ép kiêu zô
        controller =  NavHostFragment.findNavController(DSMatHang.this);
        ((MainActivity)getActivity()).controller = controller;

        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigate(R.id.action_DSMatHang_to_product);
            }
        });
    }

    private class ProductViewHolder extends RecyclerView.ViewHolder  implements OnClickListener {
        TextView txtName, txtPrice, txtDesc;
        ImageView imgCart;
        Product p;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            imgCart = itemView.findViewById(R.id.imgCart);

            imgCart.setOnClickListener(this);

        }
        public void bind(Product p ){
            this.p = p;
            txtName.setText(p.getName());
            txtPrice.setText(new Integer(p.getPrice()).toString());
            txtDesc.setText(p.getDesc());
        }

        @Override
        public void onClick(View v) {
            iController = (IController)getActivity().getApplication();
            if(iController.Check(p)){
                Toast.makeText(getActivity(), "Đã thêm " + p.getName() + " vào giỏ hàng",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getActivity(), "Đã có " + p.getName() + " ở trong giỏ hàng",
                        Toast.LENGTH_SHORT).show();
            }

        }
    }

    private  class ProductADapter extends RecyclerView.Adapter<ProductViewHolder> {

        ArrayList<Product> listproduct;
        public ProductADapter(ArrayList<Product> listproduct) {
            this.listproduct = listproduct;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout. product_item, parent, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(listproduct.get(position));
        }

        @Override
        public int getItemCount() {
            return listproduct.size();
        }


    }
}
