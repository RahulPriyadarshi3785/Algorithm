public class TestingStringBuilder {

    @SuppressWarnings("unused")
	private static String a;

    public static void main( String[] args ) throws Exception {
        StringBuilder sb = new StringBuilder();
        long time = System.currentTimeMillis();
        for( int i = 0; i < 100000000; i++ ) {
            sb.setLength( 0 );//Best
            sb.append( "someString" );
            sb.append( "someString2" );
            sb.append( "someStrin4g" );
            sb.append( "someStr5ing" );
            sb.append( "someSt7ring" );
            setA( sb.toString() );
        }
        System.out.print( System.currentTimeMillis()-time );
        System.out.println(" => setLength" );
        sb = new StringBuilder();
        time = System.currentTimeMillis();
        for( int i = 0; i < 100000000; i++ ) {
            sb.setLength( 0 );
            sb.trimToSize();
            sb.append( "someString" );
            sb.append( "someString2" );
            sb.append( "someStrin4g" );
            sb.append( "someStr5ing" );
            sb.append( "someSt7ring" );
            setA( sb.toString() );
        }
        System.out.print( System.currentTimeMillis()-time );
        System.out.println(" => setLength + trimtosize" );
        sb = new StringBuilder();
        time = System.currentTimeMillis();
        for( int i = 0; i < 100000000; i++ ) {
            sb.delete( 0, sb.length() );
            sb.append( "someString" );
            sb.append( "someString2" );
            sb.append( "someStrin4g" );
            sb.append( "someStr5ing" );
            sb.append( "someSt7ring" );
            setA( sb.toString() );
        }
        System.out.print( System.currentTimeMillis()-time );
        System.out.println(" => delete" );
        sb = new StringBuilder();
        time = System.currentTimeMillis();
        for( int i = 0; i < 100000000; i++ ) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append( "someString" );
            sb2.append( "someString2" );
            sb2.append( "someStrin4g" );
            sb2.append( "someStr5ing" );
            sb2.append( "someSt7ring" );
            setA( sb.toString() );
        }
        System.out.print( System.currentTimeMillis()-time );
        System.out.println(" => new string builder" );
        sb = new StringBuilder();
        sb.append( "someString" );
        sb.append( "someString2" );
        sb.append( "someStrin4g" );
        sb.append( "someStr5ing" );
        sb.append( "someSt7ring" );
        System.out.println(sb);
        sb.setLength(0);
        sb.append( "someString1" );
        System.out.println(sb);
        sb.setLength(0);
        sb.trimToSize();
        sb.append( "someString1" );
        System.out.println(sb);
        sb.delete(0,sb.length());
        sb.append( "someString2" );
        System.out.println(sb);
    }

    private static void setA( String aString ) {
        a = aString;
    }
}