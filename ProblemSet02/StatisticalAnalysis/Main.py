import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.ticker import FuncFormatter

data = pd.read_csv('ProblemSet02\\Output\\results.csv')
data["ExecutionTime"] = data["ExecutionTime"] / 1_000_000  # Nanoseconds to milliseconds

result_df = data.groupby(["Algorithm", "InputSize"])["ExecutionTime"].agg(
    mean_execution_time="mean",
    std_execution_time="std"
).reset_index()

# 1. Initialize the figure and axis
fig, ax = plt.subplots(figsize=(11, 7)) 
unique_algorithms = result_df["Algorithm"].unique()

# 2. Graph an isolated, sequential data trajectory for each unique algorithm
for algo in unique_algorithms:
    algo_data = result_df[result_df["Algorithm"] == algo].sort_values(by="InputSize")
    
    # Graph lines and error bars
    ax.errorbar(
        x=algo_data["InputSize"],
        y=algo_data["mean_execution_time"],
        yerr=algo_data["std_execution_time"],  
        label=algo,
        marker="o",                            
        capsize=5,                             
        linewidth=2,                           
        linestyle="-"                          
    )
    
    # --- POINT LABELS ---
    for x, y in zip(algo_data["InputSize"], algo_data["mean_execution_time"]):
        # Top line goes up, bottom line goes down to clear the error bar whiskers
        if algo == "SelectionSort":
            offset_y = 12
            valign = 'bottom'
        else:
            offset_y = -14
            valign = 'top'
            
        ax.annotate(
            text=f"{y:.3g} ms", 
            xy=(x, y), 
            textcoords="offset points", 
            xytext=(0, offset_y), 
            ha='center',        
            va=valign,            
            fontsize=8,        
            color='#444444',  
            alpha=0.9         
        )

# 3. Inject descriptive axis metadata markers and clear titling labels
ax.set_title("Algorithm Execution Time vs Input Size (with Std Dev)", fontsize=14, pad=15)
ax.set_xlabel("Input Size (n)", fontsize=12)
ax.set_ylabel("Execution Time (milliseconds)", fontsize=12) 

# 4. Apply regular logarithmic scales
ax.set_xscale('log')
ax.set_yscale('log')

# 5. Regular Log Scaling Formatter (Cleans up scientific notation for standard log steps)
ax.yaxis.set_major_formatter(FuncFormatter(lambda y, _: '{:g}'.format(y)))

# 6. Force Every Input Size onto X-Axis Ticks
unique_sizes = sorted(result_df["InputSize"].unique())
ax.set_xticks(unique_sizes)                          
ax.set_xticklabels([str(int(x)) for x in unique_sizes]) 

# 7. Apply visual anchor layers and align geometric boundary layout margins
ax.grid(True, which="both", linestyle="--", alpha=0.4)  
ax.legend(title="Algorithms", fontsize=11, loc="upper left") 
plt.tight_layout()                                      

plt.show()
