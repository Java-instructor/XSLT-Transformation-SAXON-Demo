<xsl:stylesheet version="2.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:math="http://www.oracle.com/XSL/Transform/java/java.lang.Math" 
xmlns:fun="http://www.oracle.com/XSL/Transform/java/com.java.instructor.xslt.utils.LibUtil"
exclude-result-prefixes="math fun" >

	<xsl:param name="_test"/>
	<xsl:param name="_test2"/>
		
	<xsl:param name="_test4"/>
    
	<xsl:template match="@*|node()">
		  <xsl:copy>
		<testValue>
			
		
            <xsl:attribute name="c">
                <xsl:value-of select="$_test/a/c"/>
            </xsl:attribute>
            <xsl:attribute name="d">
               <xsl:value-of select="$_test/a/d"/>
            </xsl:attribute>
            <!-- <xsl:apply-templates select="@*|node()"/> -->
     
		</testValue>
		   </xsl:copy>
      

		<testValue2>
			<xsl:value-of select="$_test2"/>
		</testValue2>
			<javavalue>
				<xsl:value-of select="math:ceil(12.34)"/>
			</javavalue>
		<date>
	 		<xsl:value-of select="math:random()" />
		</date>
		
		<Hello>
	 		<xsl:value-of select="fun:toUpperCase('hi Java Instructor')" />
		</Hello>
		
		<timestamp>
	 		<xsl:value-of select="fun:timestamp()" />
		</timestamp>


    </xsl:template> 
    

</xsl:stylesheet>