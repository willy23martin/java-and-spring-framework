/**
 * 
 */
package openweb.wmc.java.eight;

/**
 * @author wchavez
 *
 */
public class AuxiliarClass {

	public AuxiliarClass() {

	}

	public static double ortographyScore(double ortography, double grammatic, double coherence, double cohesion,
			double referencesScore) {
		double ortographyScore = ortography * 0.03 + grammatic * 0.03 + coherence * 0.03 + cohesion * 0.03
				+ referencesScore * 0.03;
		return ortographyScore;
	}

}
