package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Actor {

	private int actor_id;

	private String first_name;

	private String last_name;

	private Timestamp last_update;

}
