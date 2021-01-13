/**
 * 
 */
package openweb.wmc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author William Martín Chávez
 *
 */

@Data @AllArgsConstructor @NoArgsConstructor
public class Contact {

	private String id;
	private String name;
	private String email;
	private String telephone;

}
