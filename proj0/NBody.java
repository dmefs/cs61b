public class NBody {
    
    public static double readRadius(String s) {
        In in = new In(s);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String s) {
        In in = new In(s);
        int num = in.readInt();
        double radius = in.readDouble();
        Planet[] ps = new Planet[num];

        for (int i = 0; i < num; i++) {
            ps[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readString());
        }
        return ps;
    }
}
