package com.example.adamgarcia.enu;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adamgarcia.enu.fragments.AcceuilParentFragment;
import com.example.adamgarcia.enu.fragments.AddCreditForParentFragment;
import com.example.adamgarcia.enu.fragments.ChildrenParentsFragment;
import com.example.adamgarcia.enu.fragments.CreateChildrenParentsFragment;
import com.example.adamgarcia.enu.fragments.ParentDemandesFromChildFragment;
import com.example.adamgarcia.enu.fragments.ParentFragment;
import com.example.adamgarcia.enu.fragments.ParentMyAccountFragment;
import com.example.adamgarcia.enu.fragments.ResearchCourseForParentFragment;
import com.example.adamgarcia.enu.fragments.ResultResearchCourseForParentFragment;
import com.example.adamgarcia.enu.model.Parent;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class AcceuilParentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        AcceuilParentFragment.OnFragmentInteractionListener,
        ChildrenParentsFragment.OnFragmentInteractionListener,
        CreateChildrenParentsFragment.OnFragmentInteractionListener,
        ChildrenParentsFragment.communicationWithParent,
        CreateChildrenParentsFragment.communicationWithListChild,
        ResearchCourseForParentFragment.communicationForSearchCourseParent,
        ResearchCourseForParentFragment.OnFragmentInteractionListener,
        ResultResearchCourseForParentFragment.OnFragmentInteractionListener,
        AddCreditForParentFragment.communicationForAddCredit,
        AddCreditForParentFragment.OnFragmentInteractionListener,
        ParentMyAccountFragment.OnFragmentInteractionListener,
        ParentMyAccountFragment.deleteAccountParent,
        ParentDemandesFromChildFragment.OnFragmentInteractionListener,
        ParentDemandesFromChildFragment.returnAcceuilFromDemandes{


    FragmentManager fragmentManager;
    private Parent parent;
    String mail;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_parent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mail = getIntent().getStringExtra("mail");

        parent = Parent.getParent(mail);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View view = navigationView.getHeaderView(0);

        TextView tvCred = (TextView) findViewById(R.id.TV_parent_credit);


        fragmentManager = getSupportFragmentManager();
        //Changer de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, AcceuilParentFragment.newInstance(parent));
        fragmentTransaction.commit();


        TextView tvPrenom = (TextView) view.findViewById(R.id.TV_drawer_monPrenom_parent);
        TextView tvNom = (TextView) view.findViewById(R.id.TV_drawer_monNom_parent);
        TextView tvMail = (TextView) view.findViewById(R.id.TV_drawer_monMail_parent);


        tvCred.setText(String.valueOf(parent.getCredit()));
        tvNom.setText(parent.getNom());
        tvPrenom.setText(parent.getPrenom());
        tvMail.setText(parent.getMailAdress());


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void addChild() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fragmentManager = getSupportFragmentManager();
        //Changer de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, CreateChildrenParentsFragment.newInstance(this));
        fragmentTransaction.commit();
    }

    @Override
    public void addChildForParent(String name, String firstname, String login, String password, String confirm,String date,String classe) {


        if (!name.isEmpty() && !firstname.isEmpty() && !login.isEmpty() && !password.isEmpty() &&
                !date.isEmpty() && !classe.isEmpty() && !login.equals(confirm)) {
            Parent.getParent(mail).addChild(name, firstname, 0, login, password, date, classe);
            fragmentManager = getSupportFragmentManager();
            //Changer de fragment
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, ChildrenParentsFragment.newInstance(this,parent));
            fragmentTransaction.commit();
        } else {

            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(AcceuilParentActivity.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(AcceuilParentActivity.this);
            }
            builder.setTitle("Mauvaise saisie")
                    .setMessage("Vérifier les champs")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }


        }

    public void returnPreviousFragment() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        //Changer de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, ChildrenParentsFragment.newInstance(AcceuilParentActivity.this,parent));
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acceuil_parent, menu);
        return true;
    }


    public void addCreditParent(int cred) {
        TextView credit = (TextView) findViewById(R.id.TV_parent_credit);

        final int cr = Integer.valueOf(credit.getText().toString()) + cred;

        Parent.getParent(mail).setCredit(Integer.valueOf(Parent.getParent(mail).getCredit()) + cred);


        credit.setText(String.valueOf(cr));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        //Changer de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, AcceuilParentFragment.newInstance(parent));
        fragmentTransaction.commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        //Changer de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (id == R.id.nav_parent_acceuil) {
            // Handle the camera action
            fragmentTransaction.replace(R.id.container, AcceuilParentFragment.newInstance(parent));
        } else if (id == R.id.nav_parent_Cours) {
            fragmentTransaction.replace(R.id.container, ResearchCourseForParentFragment.newInstance(this));

        } else if (id == R.id.nav_parent_deconnexion) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_parent_demandes) {
            fragmentTransaction.replace(R.id.container, ParentDemandesFromChildFragment.newInstance(this));

        } else if (id == R.id.nav_parent_mesEnfants) {
            //Marche pas
            fragmentTransaction.replace(R.id.container, ChildrenParentsFragment.newInstance(this,parent));

        } else if (id == R.id.nav_parent_monCompte) {
            fragmentTransaction.replace(R.id.container, ParentMyAccountFragment.newInstance(this,parent));
        } else if (id == R.id.nav_parent_recharger) {
            fragmentTransaction.replace(R.id.container, AddCreditForParentFragment.newInstance(this));
        }
        fragmentTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void research() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Parent parent = new Parent();
        fragmentManager = getSupportFragmentManager();
        //Changer de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, ResultResearchCourseForParentFragment.newInstance(getApplicationContext()));
        fragmentTransaction.commit();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("AcceuilParent Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void deleteAccout(String mail) {
        Parent.deleteAccout(mail);
    }

    @Override
    public void returnAcceuilFromDemandes() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        //Changer de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, AcceuilParentFragment.newInstance(parent));
        fragmentTransaction.commit();
    }
}

