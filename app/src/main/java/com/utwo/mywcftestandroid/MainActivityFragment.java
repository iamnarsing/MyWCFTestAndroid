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
import com.utwo.mywcftestandroid.Services.WCFTestService;

import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.List;

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
                                    new WCFTestService("http://192.168.80.87:4220/WCFSerialization/ProductService.svc", "IProductService");

                            /*Single Class
                            ServiceMapping[] mappings = new ServiceMapping[1];
                            mappings[0] = new ServiceMapping("Product", Product.class);

                            ServiceParameter[] params = new ServiceParameter[1];
                            params[0] = new ServiceParameter("productid", 1, Integer.class);

                            SoapObject result = service.Invoke("GetProductByID", params, mappings);
                            Product product = (Product) CastObject.parseToObject(result, Product.class);
                            */

                            /* return List
                            ServiceMapping[] mappings = new ServiceMapping[1];
                            mappings[0] = new ServiceMapping("Product", Product.class);

                            SoapObject result = service.Invoke("GetAllProduct", null, mappings);

                            ArrayList<Product> products = new ArrayList();

                            for (int i = 0; i < result.getPropertyCount(); i++) {
                                products.add((Product) CastObject.parseToObject((SoapObject)result.getProperty(i), Product.class));
                            }
                            */


                        } catch (Exception e) {

                        }
                    }
                }
        );

        return rootView;
    }
}
