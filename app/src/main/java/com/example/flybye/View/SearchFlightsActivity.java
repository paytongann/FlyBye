package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.load.engine.Resource;
import com.example.flybye.Model.Results;
import com.example.flybye.R;

import java.util.Calendar;

public class SearchFlightsActivity extends AppCompatActivity {

    Spinner stateSpinner, airportSpinner, stateSpinnerArrival, airportSpinnerArrival;
    Button btnDepartureDate, btnArrivalDate, btnFindFlights;
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flights);

        stateSpinner = findViewById(R.id.spinner_state);
        final ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(
                SearchFlightsActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.states));
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (stateSpinner.getItemAtPosition(i).equals("Alabama")) {
                    setAirport(R.array.alabama_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Alaska")) {
                    setAirport(R.array.alaska_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Arizona")) {
                    setAirport(R.array.arizona_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Arkansas")) {
                    setAirport(R.array.arkansas_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("California")) {
                    setAirport(R.array.california_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Colorado")) {
                    setAirport(R.array.colorado_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Connecticut")) {
                    setAirport(R.array.connecticut_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("District of Columbia")) {
                    setAirport(R.array.district_of_columbia_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Florida")) {
                    setAirport(R.array.florida_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Georgia")) {
                    setAirport(R.array.georgia_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Hawaii")) {
                    setAirport(R.array.hawaii_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Idaho")) {
                    setAirport(R.array.idaho_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Illinois")) {
                    setAirport(R.array.illinois_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Indiana")) {
                    setAirport(R.array.indiana_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Iowa")) {
                    setAirport(R.array.iowa_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Kansas")) {
                    setAirport(R.array.kansas_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Kentucky")) {
                    setAirport(R.array.kentucky_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Louisiana")) {
                    setAirport(R.array.louisiana_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Maine")) {
                    setAirport(R.array.maine_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Maryland")) {
                    setAirport(R.array.maryland_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Massachusetts")) {
                    setAirport(R.array.massachusetts_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Michigan")) {
                    setAirport(R.array.michigan_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Minnesota")) {
                    setAirport(R.array.minnesota_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Mississippi")) {
                    setAirport(R.array.mississippi_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Missouri")) {
                    setAirport(R.array.missouri_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Montana")) {
                    setAirport(R.array.montana_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Nebraska")) {
                    setAirport(R.array.nebraska_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Nevada")) {
                    setAirport(R.array.nevada_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("New Hampshire")) {
                    setAirport(R.array.new_hampshire_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("New Jersey")) {
                    setAirport(R.array.new_jersey_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("New Mexico")) {
                    setAirport(R.array.new_mexico_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("New York")) {
                    setAirport(R.array.new_york_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("North Carolina")) {
                    setAirport(R.array.north_carolina_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("North Dakota")) {
                    setAirport(R.array.north_dakota_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Ohio")) {
                    setAirport(R.array.ohio_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Oklahoma")) {
                    setAirport(R.array.oklahoma_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Oregon")) {
                    setAirport(R.array.oregon_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Pennsylvania")) {
                    setAirport(R.array.pennsylvania_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Rhode Island")) {
                    setAirport(R.array.rhode_island_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("South Dakota")) {
                    setAirport(R.array.south_dakota_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Tennessee")) {
                    setAirport(R.array.tennessee_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Texas")) {
                    setAirport(R.array.texas_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Vermont")) {
                    setAirport(R.array.vermont_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Virginia")) {
                    setAirport(R.array.virginia_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Washington")) {
                    setAirport(R.array.washington_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("West Virginia")) {
                    setAirport(R.array.west_virginia_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Wisconsin")) {
                    setAirport(R.array.wisconsin_airports);
                } else if (stateSpinner.getItemAtPosition(i).equals("Wyoming")) {
                    setAirport(R.array.wyoming_airports);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        stateSpinnerArrival = findViewById(R.id.spinner_state_arrival);
        final ArrayAdapter<String> stateAdapterArrival = new ArrayAdapter<String>(
                SearchFlightsActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.states));
        stateAdapterArrival.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinnerArrival.setAdapter(stateAdapterArrival);
        stateSpinnerArrival.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (stateSpinnerArrival.getItemAtPosition(i).equals("Alabama")) {
                    setAirportArrival(R.array.alabama_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Alaska")) {
                    setAirportArrival(R.array.alaska_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Arizona")) {
                    setAirportArrival(R.array.arizona_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Arkansas")) {
                    setAirportArrival(R.array.arkansas_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("California")) {
                    setAirportArrival(R.array.california_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Colorado")) {
                    setAirportArrival(R.array.colorado_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Connecticut")) {
                    setAirportArrival(R.array.connecticut_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("District of Columbia")) {
                    setAirportArrival(R.array.district_of_columbia_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Florida")) {
                    setAirportArrival(R.array.florida_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Georgia")) {
                    setAirportArrival(R.array.georgia_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Hawaii")) {
                    setAirportArrival(R.array.hawaii_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Idaho")) {
                    setAirportArrival(R.array.idaho_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Illinois")) {
                    setAirportArrival(R.array.illinois_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Indiana")) {
                    setAirportArrival(R.array.indiana_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Iowa")) {
                    setAirportArrival(R.array.iowa_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Kansas")) {
                    setAirportArrival(R.array.kansas_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Kentucky")) {
                    setAirportArrival(R.array.kentucky_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Louisiana")) {
                    setAirportArrival(R.array.louisiana_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Maine")) {
                    setAirportArrival(R.array.maine_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Maryland")) {
                    setAirportArrival(R.array.maryland_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Massachusetts")) {
                    setAirportArrival(R.array.massachusetts_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Michigan")) {
                    setAirportArrival(R.array.michigan_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Minnesota")) {
                    setAirportArrival(R.array.minnesota_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Mississippi")) {
                    setAirportArrival(R.array.mississippi_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Missouri")) {
                    setAirportArrival(R.array.missouri_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Montana")) {
                    setAirportArrival(R.array.montana_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Nebraska")) {
                    setAirportArrival(R.array.nebraska_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Nevada")) {
                    setAirportArrival(R.array.nevada_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("New Hampshire")) {
                    setAirportArrival(R.array.new_hampshire_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("New Jersey")) {
                    setAirportArrival(R.array.new_jersey_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("New Mexico")) {
                    setAirportArrival(R.array.new_mexico_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("New York")) {
                    setAirportArrival(R.array.new_york_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("North Carolina")) {
                    setAirportArrival(R.array.north_carolina_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("North Dakota")) {
                    setAirportArrival(R.array.north_dakota_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Ohio")) {
                    setAirportArrival(R.array.ohio_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Oklahoma")) {
                    setAirportArrival(R.array.oklahoma_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Oregon")) {
                    setAirportArrival(R.array.oregon_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Pennsylvania")) {
                    setAirportArrival(R.array.pennsylvania_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Rhode Island")) {
                    setAirportArrival(R.array.rhode_island_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("South Dakota")) {
                    setAirportArrival(R.array.south_dakota_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Tennessee")) {
                    setAirportArrival(R.array.tennessee_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Texas")) {
                    setAirportArrival(R.array.texas_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Vermont")) {
                    setAirportArrival(R.array.vermont_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Virginia")) {
                    setAirportArrival(R.array.virginia_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Washington")) {
                    setAirportArrival(R.array.washington_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("West Virginia")) {
                    setAirportArrival(R.array.west_virginia_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Wisconsin")) {
                    setAirportArrival(R.array.wisconsin_airports);
                } else if (stateSpinnerArrival.getItemAtPosition(i).equals("Wyoming")) {
                    setAirportArrival(R.array.wyoming_airports);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnDepartureDate = findViewById(R.id.select_departure_date);
        btnDepartureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(SearchFlightsActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                monthOfYear++;
                                String month = monthOfYear + "";
                                if (monthOfYear < 10) {
                                    month = "0" + monthOfYear;
                                }
                                String day = dayOfMonth + "";
                                if (dayOfMonth < 10) {
                                    day = "0" + dayOfMonth;
                                }
                                btnDepartureDate.setText(year + "/" + month + "/" + day);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        btnDepartureDate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                btnDepartureDate.setText("Select Departure Date");
                return false;
            }
        });

        btnArrivalDate = findViewById(R.id.select_return_date);
        btnArrivalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(SearchFlightsActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                monthOfYear++;
                                String month = monthOfYear + "";
                                if (monthOfYear < 10) {
                                    month = "0" + monthOfYear;
                                }
                                String day = dayOfMonth + "";
                                if (dayOfMonth < 10) {
                                    day = "0" + dayOfMonth;
                                }
                                btnArrivalDate.setText(year + "/" + month + "/" + day);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        btnArrivalDate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                btnArrivalDate.setText("Select Return Date");
                return false;
            }
        });
        btnFindFlights = findViewById(R.id.btn_find_flights);
        btnFindFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateSpinner.getSelectedItem().toString().equals("Select State")) {
                    Toast.makeText(SearchFlightsActivity.this, "Select Departure State", Toast.LENGTH_SHORT).show();
                } else if (airportSpinner.getSelectedItem().toString().equals("Select Airport")) {
                    Toast.makeText(SearchFlightsActivity.this, "Select Departure Airport", Toast.LENGTH_SHORT).show();
                } else if (btnDepartureDate.getText().toString().equals("Select Departure Date")) {
                    Toast.makeText(SearchFlightsActivity.this, "Select Departure Date", Toast.LENGTH_SHORT).show();
                } else if (stateSpinnerArrival.getSelectedItem().toString().equals("Select State")) {
                    Toast.makeText(SearchFlightsActivity.this, "Select Arrival State", Toast.LENGTH_SHORT).show();
                } else if (airportSpinnerArrival.getSelectedItem().toString().equals("Select Airport")) {
                    Toast.makeText(SearchFlightsActivity.this, "Select Arrival Airport", Toast.LENGTH_SHORT).show();
                } else {
                    //todo pass values to next activity
                    Intent intent = new Intent(SearchFlightsActivity.this, ResultsActivity.class);
                    setResult(RESULT_OK,intent);
                    startActivity(intent);
                }
            }
        });
    }

    public void setAirport(int airport) {
        airportSpinner = findViewById(R.id.spinner_airport);
        ArrayAdapter<String> airportAdapter = new ArrayAdapter<String>(
                SearchFlightsActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(airport));
        airportAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        airportSpinner.setAdapter(airportAdapter);
    }

    public void setAirportArrival(int airport) {
        airportSpinnerArrival = findViewById(R.id.spinner_airport_arrival);
        ArrayAdapter<String> airportAdapter = new ArrayAdapter<String>(
                SearchFlightsActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(airport));
        airportAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        airportSpinnerArrival.setAdapter(airportAdapter);
    }
}
