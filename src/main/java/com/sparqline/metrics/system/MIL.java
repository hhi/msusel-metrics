/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

public class MIL extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -7085516699762884385L;

    public static MIL getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new MIL("", "", "MIL", MetricScope.ClassLevel, entity, graph);
    }

    private MIL(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
    }
}
