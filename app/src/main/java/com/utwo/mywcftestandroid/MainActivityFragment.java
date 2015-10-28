package com.utwo.mywcftestandroid;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.utwo.mywcftestandroid.Models.CastObject;
import com.utwo.mywcftestandroid.Models.Product;
import com.utwo.mywcftestandroid.Services.ServiceMapping;
import com.utwo.mywcftestandroid.Services.ServiceParameter;
import com.utwo.mywcftestandroid.Services.WCFTestService;

import org.ksoap2.serialization.SoapObject;

import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    View rootView = null;
    Button mBtnTest = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mBtnTest = (Button) rootView.findViewById(R.id.btnTest);

        mBtnTest.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        try {
                            WCFTestService service =
                                    new WCFTestService("http://192.168.80.87:4229/WCFSerialization/ProductService.svc", "IProductService");

                            /*Single Class Argument
                            ServiceMapping[] mappings = new ServiceMapping[1];
                            mappings[0] = new ServiceMapping("Product", Product.class);

                            ServiceParameter[] params = new ServiceParameter[1];
                            params[0] = new ServiceParameter("productid", 1, Integer.class);

                            Object result = service.Invoke("GetProductByID", params, mappings);
                            Product product = (Product) CastObject.parseToObject(result, Product.class);
                            product.toString();*/

                            /* return List
                            ServiceMapping[] mappings = new ServiceMapping[1];
                            mappings[0] = new ServiceMapping("Product", Product.class);

                            SoapObject result = service.Invoke("GetAllProduct", null, mappings);

                            ArrayList<Product> products = new ArrayList();

                            for (int i = 0; i < result.getPropertyCount(); i++) {
                                products.add((Product) CastObject.parseToObject(result.getProperty(i), Product.class));
                            }
                            */

                            /*Class Argument
                            ServiceMapping[] mappings = new ServiceMapping[1];
                            mappings[0] = new ServiceMapping("Product", Product.class);

                            Product product = new Product();
                            product.setProductID(4);
                            product.setProductName("BlackBerry");
                            product.setSoldOutDate(new Date());
                            product.setIsSoldOut(false);
                            product.setUnitPrice(566.55f);
                            ServiceParameter[] params = new ServiceParameter[1];
                            params[0] = new ServiceParameter("product", product, Product.class);

                            Boolean result = (Boolean) service.Invoke("Create", params, mappings);
                            */

                            //List Argument And List Return
                            ServiceMapping[] mappings = new ServiceMapping[1];
                            mappings[0] = new ServiceMapping("Product", Product.class);

                            Vector<Product> listProduct = new Vector<>();

                            Product product1 = new Product();
                            product1.setProductID(1);
                            product1.setProductName("BlackBerry");
                            product1.setSoldOutDate(new Date());
                            product1.setIsSoldOut(false);
                            product1.setUnitPrice(646.55f);
                            listProduct.add(product1);

                            Product product2 = new Product();
                            product2.setProductID(2);
                            product2.setProductName("BlueBerry");
                            product2.setSoldOutDate(new Date());
                            product2.setIsSoldOut(false);
                            product2.setUnitPrice(566.55f);
                            listProduct.add(product2);

                            ServiceParameter[] params = new ServiceParameter[1];
                            params[0] = new ServiceParameter("products", listProduct, Vector.class, "Product", Product.class);

                            SoapObject result = (SoapObject)service.Invoke("ProductListOrderByPrice", params, mappings);

                        } catch (Exception e) {
                        }
                    }
                }
        );

        return rootView;
    }
}
