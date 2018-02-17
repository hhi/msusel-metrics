/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/**
 * 
 */
package metrics

import codetree.AbstractNode
import codetree.Accessibility
import codetree.TypeNode
import metrics.annotations.MetricCategory
import metrics.annotations.MetricDefinition
import metrics.annotations.MetricProperties
import metrics.annotations.MetricScale
import metrics.annotations.MetricScope
import metrics.annotations.MetricType

/**
 * @author Isaac Griffith
 *
 */
@MetricDefinition(
    name = "Number of Attributes Inherited",
    primaryHandle = "NAI",
    description = "Count of the number of attributes inherited from all ancestor classes of the measured class.",
    properties = @MetricProperties(
        range = "Positive Integer",
        aggregation = [],
        scope = MetricScope.TYPE,
        type = MetricType.Model,
        scale = MetricScale.Interval,
        category = MetricCategory.Inheritance
    ),
    references = [
        'Hudli, Raghu V., Curtis L. Hoskins, and Anand V. Hudli. "Software metrics for object-oriented designs." Computer Design: VLSI in Computers and Processors, 1994. ICCD\'94. Proceedings., IEEE International Conference on. IEEE, 1994.'
    ]
)
class NumberOfAttributesInherited extends AbstractMetric {

    /**
     * 
     */
    public NumberOfAttributesInherited()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node)
    {
        int total = 0
        
        if (node instanceof TypeNode) {
            def attrs = []
            
            tree.getAllParentClasses(node) {
                attrs += it.fields().findAll { it.accessibility != Accessibility.PRIVATE }
            }
            
            total = attrs.size()
        }
        
        total
    }

}