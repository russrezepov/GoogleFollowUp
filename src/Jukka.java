import java.util.Arrays;

public class Jukka {

        static class Classroom
        {
            int[][] studentRelations;
            int numOfStudents;

            Classroom(int[][] mat, int v)
            {
                this.studentRelations = mat;
                this.numOfStudents = v;
            }

            void addRelation(int src, int dest, int pobc)
            {
                studentRelations[src][dest] = pobc;
                studentRelations[dest][src] = pobc;
            }

            //Now we need to find the closest unvisited(not asked to pass a cheat paper) Student
            public static int getClosestStudent(int[] distance, boolean[] visited)
            {
                int min = Integer.MAX_VALUE;
                int minIdx = -1;
                for(int i=0; i<distance.length; i++)
                {
                    if(distance[i] < min)
                        if(visited[i] == false)
                        {
                            min = distance[i];
                            minIdx = i;
                        }
                }
                return minIdx;
            }

            //parameters passed - classroom(graph implementation) and the starting student - our source
            public static int[] safestPath(Classroom classroom, int src)
            {
                // init of shortest distance array
                int[] distance = new int[classroom.numOfStudents];

                //checking of the less dangerous path is found
                boolean[] visited = new boolean[classroom.numOfStudents];

                //initializing the arrays
                for(int i=0; i<classroom.numOfStudents; i++)
                {
                    //the distance in the beginning is infinite
                    distance[i] = Integer.MAX_VALUE;
                    //marking all students as not visited yet which also means
                    // tha the safest path is not found yet
                    visited[i] = false;
                }
                distance[src] = 0;

                for(int i=0; i<classroom.numOfStudents; i++)
                {
                    //finding closest student
                    int closestStudent = getClosestStudent(distance, visited);

                    //if closest student is infinite distance away, it means that no other students can be reached

                    if(closestStudent == Integer.MAX_VALUE)
                        return distance;

                    visited[closestStudent] = true;
                    for(int j=0; j<classroom.numOfStudents; j++)
                    {
                        //the j student shortest distance should not be finalized
                        if(visited[j] == false)
                        {
                            if(classroom.studentRelations[closestStudent][j] != 0)
                            {

                                //distance through closestStudent is less than the initial distance
                                int d = distance[closestStudent] + classroom.studentRelations[closestStudent][j];
                                if(d < distance[j])
                                    distance[j] = d;
                            }
                        }
                    }
                }
                return distance;
            }
        }

        public static void main(String[] args)
        {
            int numberOfStudents = 6;
            int[][] studentRelations = new int[6][6];
            Classroom classroom = new Classroom(studentRelations, numberOfStudents);
            classroom.addRelation(0, 4, 21);
            classroom.addRelation(0, 3, 18);
            classroom.addRelation(2, 1, 7);
            classroom.addRelation(1, 4, 6);
            classroom.addRelation(4, 5, 10);
            classroom.addRelation(4, 3, 11);
            int[] safestPath = classroom.safestPath(classroom, 0);
            System.out.print(Arrays.toString(safestPath));
        }

}
