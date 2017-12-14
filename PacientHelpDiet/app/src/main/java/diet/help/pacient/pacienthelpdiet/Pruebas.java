package diet.help.pacient.pacienthelpdiet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pruebas extends AppCompatActivity {
    Button registrar;
    TipoDietas tipoDietas;
    String UDI;
    FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas);
        registrar=(Button)findViewById(R.id.btn_registar);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        Log.i("database1",database.toString());
        final DatabaseReference reference=database.getReference(FirebaseReferences.CATEGORIAS_REFERENCIAS);
        final DatabaseReference reference1=database.getReference(FirebaseReferences.ALIMENTOS_REFERENCIAS);
        final DatabaseReference reference2=database.getReference(FirebaseReferences.HOSPITALIZACION_REFERENCIAS);
        final DatabaseReference reference3=database.getReference(FirebaseReferences.OPERACION_REFERENCIAS);
        final DatabaseReference reference4=database.getReference(FirebaseReferences.PACIENTE_REFERENCIAS);
        final DatabaseReference reference5=database.getReference(FirebaseReferences.USER_REFERENCIAS);
        final DatabaseReference reference6=database.getReference(FirebaseReferences.DIETA_REFERENCIAS);
        final DatabaseReference reference7=database.getReference(FirebaseReferences.DETALLE_REFERENCIAS);
        Log.i("database2",reference.toString());
        mAuthListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    UDI=user.getUid();
                }else {
                    Intent intent=new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplicationContext(),"Cerrar",Toast.LENGTH_SHORT).show();
                }

            }
        };
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("database7",reference.toString());
                TipoDietas tipoDietas=new TipoDietas("basal","Solo se puede el consumo de liquidos nada solidos");
                reference.push().setValue(tipoDietas);
                reference.orderByChild("tipo").equalTo("basal").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds: dataSnapshot.getChildren()){
                            Alimentos ali=new Alimentos("https://firebasestorage.googleapis.com/v0/b/pacienthelpdiet-a07fb.appspot.com/o/agua.jpg?alt=media&token=59336f2a-a04a-4861-94e2-d552a9c05206",
                                    "Carne", ds.getKey());
                            reference1.push().setValue(ali);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                final String KeyA="s";

                Log.i("database7",KeyA);
                Paciente paciente=new Paciente("0123456","Alex","Villa","0235","Bosque","Soltero","12/02/1991","quiwi","AB-","Hipertencion");
                reference4.push().setValue(paciente);
                final String KeyP=reference4.push().getKey();

                Hospitalizacion hospitalizacion=new Hospitalizacion("4",KeyP,"Apendicitis","sufre una leve lecion en el estomago");
                reference2.push().setValue(hospitalizacion);
                final String KeyH=reference2.push().getKey();

                Operacion operacion=new Operacion(KeyH,"Cirugia","EL paciente padece una leve inflamacion en intestino grueso ","10/07/2010","Sala de cirugia 5");
                reference3.push().setValue(operacion);
                Dieta dieta=new Dieta("Desayuno",KeyP,"10/10/1998");
                reference6.push().setValue(dieta);
                String KeyD=reference6.push().getKey();

                Detalledieta detalledieta=new Detalledieta(KeyD,KeyA);
                reference7.push().setValue(detalledieta);
                User user=new User("012345","Alex","Tobas","014524","Bosque","1",UDI);
                reference5.push().setValue(user);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthListener!=null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}
