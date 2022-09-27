/*
 * Fwd: the port forwarding app
 * Copyright (C) 2016  Elixsr Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.elixsr.portforwarder.ui.preferences;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.elixsr.portforwarder.R;
import com.elixsr.portforwarder.models.NetItemAdapter;
import com.elixsr.portforwarder.ui.BaseActivity;
import com.elixsr.portforwarder.util.InterfaceHelper;

import java.net.SocketException;
import java.util.List;

/**
 * Created by Niall McShane on 29/02/2016.
 */
public class NetworkActivity extends BaseActivity {


    private final String TAG = "NetworkActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.network_activity);
        Toolbar toolbar = getActionBarToolbar();
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            List<InterfaceHelper.InterfaceModel> list = InterfaceHelper.generateInterfaceModelList();
            NetItemAdapter itemAdapter = new NetItemAdapter(NetworkActivity.this,R.layout.netinterface_item,list);
            ListView listView = (ListView)findViewById(R.id.netInfo);
            listView.setAdapter(itemAdapter);
        } catch (SocketException e) {

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}


