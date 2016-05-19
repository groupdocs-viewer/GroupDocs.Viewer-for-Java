package com.viewer.model;
public enum WatermarkPosition
{
		/** 
		 Default value - from bottom left to top right corner
		*/
		Diagonal,
		TopLeft,
		TopCenter,
		TopRight,
		BottomLeft,
		BottomCenter,
		BottomRight;

		public int getValue()
		{
			return this.ordinal();
		}

		public static WatermarkPosition forValue(int value)
		{
			return values()[value];
		}
}