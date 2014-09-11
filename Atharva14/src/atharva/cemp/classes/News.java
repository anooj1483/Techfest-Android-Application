package atharva.cemp.classes;

import tech.cemp.atharva14.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class News extends Fragment {
	
	private ListView lvMenu,rvMenu;
	private String[] lvMenuItems,rvMenuItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout1, null);
        
        return view;
    }
}
